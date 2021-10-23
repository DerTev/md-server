package de.dertev.plugins

import de.dertev.FileManager
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import java.io.File

fun Application.configureRouting() {
    routing {
        File("files/").walkTopDown().forEach { file ->

            if (file.name.endsWith(".md")) {
                if (file.name == "index.md") {
                    get("/") {
                        call.respondText(FileManager(file).md2HTML(), ContentType.Text.Html)
                    }
                } else {
                    get("/${(file.name.replace(".md", "")).replace("|", "/")}") {
                        call.respondText(FileManager(file).md2HTML(), ContentType.Text.Html)
                    }
                }
            } else if (file.name.endsWith(".html")) {
                if (file.name == "index.html") {
                    get("/") {
                        call.respondText(file.readText(), ContentType.Text.Html)
                    }
                } else {
                    get("/${(file.name.replace(".html", "")).replace("|", "/")}") {
                        call.respondText(file.readText(), ContentType.Text.Html)
                    }
                }
            } else {
                get("/${file.name.replace("|", "/")}") {
                    call.respondText(file.readText(), ContentType.Any)
                }
            }
        }
    }
}
