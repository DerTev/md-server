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
        return "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>${file.name}</title><link href=\"static/style.css\", rel=\"stylesheet\"></head>$html</html>"
    }
}