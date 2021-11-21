package de.dertev

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import java.io.File

class FileManager(val file: File, private val defaultContent: String="") {

    //Loads HTML from Markdown
    fun md2HTML(): String {

        val settings: HashMap<String, String> = Json.decodeFromString(configFile.file.readText())

        val src = file.readText()
        val flavour = CommonMarkFlavourDescriptor()
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(src)
        val html = HtmlGenerator(src, parsedTree, flavour).generateHtml().replaceFirst("<body>", "")

        var navbar = "<p class=\"navbar\">"

        if (settings["navbar"].toBoolean()) {
            val navBarData: HashMap<String, String> = Json.decodeFromString(File("navbar.json").readText())

            navBarData.forEach {
                navbar += "<a href=\"${it.value}\">${it.key}</a> "
            }
            navbar += "</p>"
        }
        var title = file.name.split("|")
        title = listOf(title[title.size-1])

        var robotsIndex = ""
        var robotsFollow = ""

        robotsIndex = if (settings["robots-index"].toBoolean()) {
            "index"
        } else {
            "noindex"
        }

        robotsFollow = if (settings["robots-follow"].toBoolean()) {
            "follow"
        } else {
            "nofollow"
        }

        if (settings["navbar"].toBoolean()) {
            return "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><meta name=\"robots\" content=\"$robotsIndex,$robotsFollow\"><title>${title}</title><link href=\"/style.css\", rel=\"stylesheet\"></head><body>$navbar$html</html>"
        } else {
            return "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><meta name=\"robots\" content=\"$robotsIndex,$robotsFollow\"><title>${title}</title><link href=\"/style.css\", rel=\"stylesheet\"></head><body>$html</html>"
        }
    }

    //Creates file, if this doesn't exist
    fun createFile() {
        if (!file.exists()) {
            file.createNewFile()
            file.writeText(defaultContent)
        }
    }

    //Creates dir, if this doesn't exist
    fun createDir() {
        if (!file.exists()) {
            file.mkdir()
        }
    }
}
