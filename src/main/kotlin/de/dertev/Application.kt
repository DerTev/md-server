package de.dertev

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import de.dertev.plugins.*
import java.io.File
import java.nio.file.Paths

fun main() {

    var port = 8080
    var host = ""
    val config = File("config.yml")

    if (!(File("files/").exists())) {
        File("files/").mkdir()
    }

    if (!(File("files/style.css").exists())) {
        File("files/style.css").createNewFile()
        File("files/style.css").writeText(getExampleCSS())
    }

    if (!(config.exists())) {
        config.createNewFile()
        config.writeText("port: 8080\nhost: localhost")
    }

    config.forEachLine {
        if (it.startsWith("port: ")) {
            port = it.replaceFirst("port: ", "").toInt()
        } else if (it.startsWith("host: ")) {
            host = it.replaceFirst("host: ", "")
        }
    }

    embeddedServer(Netty, port = port, host = host) {
        configureRouting()
    }.start(wait = true)
}
