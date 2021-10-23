package de.dertev

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import de.dertev.plugins.*
import java.io.File

fun main() {
    val config = FileManager(File("config.yml"))

    FileManager(File("files/")).createDir()


    val cssFile = FileManager(File("files/style.css"))
    if (!cssFile.file.exists()) {
        cssFile.createFile()
        cssFile.write(getExampleCSS())
    }

    if (!config.file.exists()) {
        config.createFile()
        config.write("port: 80\nhost: localhost")
    }

    val port = config.getYMLData("port").toInt()
    val host = config.getYMLData("host")

    embeddedServer(Netty, port = port, host = host) {
        configureRouting()
    }.start(wait = true)
}
