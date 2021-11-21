package de.dertev.plugins

import de.dertev.FileManager
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import java.io.File

fun Application.configureRouting() {
    routing {
        get("/{...}/") {
            val currentPath = call.request.path().dropLast(1)
            if (call.request.path() == "/") {
                call.respondText(FileManager(File("files/index.md")).md2HTML(), ContentType.Text.Html)
            } else if (currentPath == "/style.css") {
                call.respondText(File("style.css").readText(), ContentType.Text.CSS)
            } else if (File("files${currentPath}.md").exists()) {
                call.respondText(FileManager(File("files${currentPath}.md")).md2HTML(), ContentType.Text.Html)
            } else if (File("files${currentPath}").exists()) {
                if (File("files${currentPath}").isDirectory) {
                    call.respondText(File("404.html").readText(), ContentType.Text.Html)
                } else {
                    call.respondFile(File("files${currentPath}"))
                }
            } else {
                call.respondText(File("404.html").readText(), ContentType.Text.Html, HttpStatusCode.NotFound)
            }
        }
        get("/{...}") {
            call.respondRedirect(call.request.path() + "/", permanent = false)
        }
    }
}
