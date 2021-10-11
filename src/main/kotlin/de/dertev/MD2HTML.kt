package de.dertev

import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import java.io.File

class MD2HTML(target: File) {
    private val file = target

    fun getHTML(): String {
        val src = file.readText()
        val flavour = CommonMarkFlavourDescriptor()
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(src)
        val html = HtmlGenerator(src, parsedTree, flavour).generateHtml()
        var title = file.name.split("|")
        title = listOf(title[title.size-1])
        return "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>${title}</title><link href=\"/style.css\", rel=\"stylesheet\"></head>$html</html>"
    }
}