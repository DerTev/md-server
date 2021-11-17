package de.dertev

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import de.dertev.plugins.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

fun main() {

    //Creates important files
    FileManager(File("files/")).createDir()
    FileManager(File("navbar.json"), Json.encodeToString(hashMapOf( "md-server" to "https://github.com/dertev/md-server/", "Home" to "/"))).createFile()
    FileManager(File("404.html"), "404").createFile()
    FileManager(File("style.css"), exampleCSS).createFile()
    FileManager(
        File("files/index.md"),
        "# It works!\n\nYou can now create pages with Markdown!\n\n[Learn how to write markdown](https://markdown.de/#block)"
    ).createFile()

    //Load Config
    val configFile = FileManager(File("config.json"), Json.encodeToString(hashMapOf("port" to "80", "host" to "localhost")))
    configFile.createFile()
    val settings: HashMap<String, String> = Json.decodeFromString(configFile.file.readText())


    //Starts the Ktor server with routing.
    embeddedServer(Netty, port = settings["port"]!!.toInt(), host = settings["host"]!!) {
        configureRouting()
    }.start(wait = true)
}
