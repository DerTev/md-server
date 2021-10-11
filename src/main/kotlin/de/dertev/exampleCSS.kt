package de.dertev

fun getExampleCSS(): String {
    return "@media print {\n" +
            "    *,\n" +
            "    *:before,\n" +
            "    *:after {\n" +
            "        background: transparent !important;\n" +
            "        color: #000 !important;\n" +
            "        box-shadow: none !important;\n" +
            "        text-shadow: none !important;\n" +
            "    }\n" +
            "\n" +
            "    a,\n" +
            "    a:visited {\n" +
            "        text-decoration: underline;\n" +
            "    }\n" +
            "\n" +
            "    a[href]:after {\n" +
            "        content: \" (\" attr(href) \")\";\n" +
            "    }\n" +
            "\n" +
            "    abbr[title]:after {\n" +
            "        content: \" (\" attr(title) \")\";\n" +
            "    }\n" +
            "\n" +
            "    a[href^=\"#\"]:after,\n" +
            "    a[href^=\"javascript:\"]:after {\n" +
            "        content: \"\";\n" +
            "    }\n" +
            "\n" +
            "    pre,\n" +
            "    blockquote {\n" +
            "        border: 1px solid #999;\n" +
            "        page-break-inside: avoid;\n" +
            "    }\n" +
            "\n" +
            "    thead {\n" +
            "        display: table-header-group;\n" +
            "    }\n" +
            "\n" +
            "    tr,\n" +
            "    img {\n" +
            "        page-break-inside: avoid;\n" +
            "    }\n" +
            "\n" +
            "    img {\n" +
            "        max-width: 100% !important;\n" +
            "    }\n" +
            "\n" +
            "    p,\n" +
            "    h2,\n" +
            "    h3 {\n" +
            "        orphans: 3;\n" +
            "        widows: 3;\n" +
            "    }\n" +
            "\n" +
            "    h2,\n" +
            "    h3 {\n" +
            "        page-break-after: avoid;\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "html {\n" +
            "    font-size: 12px;\n" +
            "}\n" +
            "\n" +
            "@media screen and (min-width: 32rem) and (max-width: 48rem) {\n" +
            "    html {\n" +
            "        font-size: 15px;\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "@media screen and (min-width: 48rem) {\n" +
            "    html {\n" +
            "        font-size: 16px;\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "body {\n" +
            "    line-height: 1.85;\n" +
            "}\n" +
            "\n" +
            "p,\n" +
            ".air-p {\n" +
            "    font-size: 1rem;\n" +
            "    margin-bottom: 1.3rem;\n" +
            "}\n" +
            "\n" +
            "h1,\n" +
            ".air-h1,\n" +
            "h2,\n" +
            ".air-h2,\n" +
            "h3,\n" +
            ".air-h3,\n" +
            "h4,\n" +
            ".air-h4 {\n" +
            "    margin: 1.414rem 0 .5rem;\n" +
            "    font-weight: inherit;\n" +
            "    line-height: 1.42;\n" +
            "}\n" +
            "\n" +
            "h1,\n" +
            ".air-h1 {\n" +
            "    margin-top: 0;\n" +
            "    font-size: 3.998rem;\n" +
            "}\n" +
            "\n" +
            "h2,\n" +
            ".air-h2 {\n" +
            "    font-size: 2.827rem;\n" +
            "}\n" +
            "\n" +
            "h3,\n" +
            ".air-h3 {\n" +
            "    font-size: 1.999rem;\n" +
            "}\n" +
            "\n" +
            "h4,\n" +
            ".air-h4 {\n" +
            "    font-size: 1.414rem;\n" +
            "}\n" +
            "\n" +
            "h5,\n" +
            ".air-h5 {\n" +
            "    font-size: 1.121rem;\n" +
            "}\n" +
            "\n" +
            "h6,\n" +
            ".air-h6 {\n" +
            "    font-size: .88rem;\n" +
            "}\n" +
            "\n" +
            "small,\n" +
            ".air-small {\n" +
            "    font-size: .707em;\n" +
            "}\n" +
            "\n" +
            "/* https://github.com/mrmrs/fluidity */\n" +
            "\n" +
            "img,\n" +
            "canvas,\n" +
            "iframe,\n" +
            "video,\n" +
            "svg,\n" +
            "select,\n" +
            "textarea {\n" +
            "    max-width: 100%;\n" +
            "}\n" +
            "\n" +
            "@import url(http://fonts.googleapis.com/css?family=Open+Sans:300italic,300);\n" +
            "\n" +
            "body {\n" +
            "    color: #444;\n" +
            "    font-family: 'Open Sans', Helvetica, sans-serif;\n" +
            "    font-weight: 300;\n" +
            "    margin: 6rem auto 1rem;\n" +
            "    max-width: 48rem;\n" +
            "    text-align: center;\n" +
            "}\n" +
            "\n" +
            "img {\n" +
            "    border-radius: 50%;\n" +
            "    height: 200px;\n" +
            "    margin: 0 auto;\n" +
            "    width: 200px;\n" +
            "}\n" +
            "\n" +
            "a,\n" +
            "a:visited {\n" +
            "    color: #3498db;\n" +
            "}\n" +
            "\n" +
            "a:hover,\n" +
            "a:focus,\n" +
            "a:active {\n" +
            "    color: #2980b9;\n" +
            "}\n" +
            "\n" +
            "pre {\n" +
            "    background-color: #fafafa;\n" +
            "    padding: 1rem;\n" +
            "    text-align: left;\n" +
            "}\n" +
            "\n" +
            "blockquote {\n" +
            "    margin: 0;\n" +
            "    border-left: 5px solid #7a7a7a;\n" +
            "    font-style: italic;\n" +
            "    padding: 1.33em;\n" +
            "    text-align: left;\n" +
            "}\n" +
            "\n" +
            "ul,\n" +
            "ol,\n" +
            "li {\n" +
            "    text-align: left;\n" +
            "}\n" +
            "\n" +
            "p {\n" +
            "    color: #777;\n" +
            "}"
}