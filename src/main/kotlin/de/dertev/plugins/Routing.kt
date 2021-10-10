package de.dertev.plugins

import de.dertev.MD2HTML
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.request.*
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import java.io.File
import java.nio.file.Paths

fun Application.configureRouting() {

    routing {
        File("pages/").walkTopDown().forEach { file ->
            if (file.name.endsWith(".md")) {
                if (file.name == "index.md") {
                    get("/") {
                        call.respondText(MD2HTML(target = file).getHTML(), ContentType.Text.Html)
                    }
                } else {
                    get("/${file.name.replace(".md", "")}") {
                        call.respondText(MD2HTML(target = file).getHTML(), ContentType.Text.Html)
                    }
                }
            }
        }

        static("/static") {
            resources("files")
        }
    }
}
