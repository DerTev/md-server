package de.dertev

import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import java.io.File

class FileManager(val file: File) {
    fun md2HTML(): String {
        val src = file.readText()
        val flavour = CommonMarkFlavourDescriptor()
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(src)
        val html = HtmlGenerator(src, parsedTree, flavour).generateHtml()
        var title = file.name.split("|")
        title = listOf(title[title.size-1])
        return "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>${title}</title><link href=\"/style.css\", rel=\"stylesheet\"></head>$html</html>"
    }

    fun getYMLData(name: String): String {
        var result = ""
        if (file.exists()) {
            file.forEachLine {
                if (it.startsWith("${name}: ")) {
                    result = it.replaceFirst("${name}: ", "")
                }
            }
        }
        return result
    }

    fun createFile() {
        if (!file.exists()) {
            file.createNewFile()
        }
    }

    fun createDir() {
        if (!file.exists()) {
            file.mkdir()
        }
    }

    fun write(content: String) {
        file.writeText(content)
    }
}