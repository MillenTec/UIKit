package com.millentec.compose.uikit.foundation

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle

data class UIKitCodeBlockConfig(
    val name: String,
    val rules: List<Pair<Regex, SpanStyle>>?,
    val colors: UIKitCodeBlockColors
) {
    companion object {
        fun text(colors: UIKitCodeBlockColors = UIKitCodeBlockColors()): UIKitCodeBlockConfig {
            return UIKitCodeBlockConfig(
                name = "Text",
                rules = null,
                colors = colors
            )
        }

        fun kotlin(colors: UIKitCodeBlockColors = UIKitCodeBlockColors()): UIKitCodeBlockConfig {
            val keyword = listOf(
                "package", "class", "data", "val", "var", "fun", "companion", "object", "as", "false", "true", "is", "if",
                "else", "break", "continue", "do", "return", "super", "this", "for", "in", "interface", "null", "throw",
                "try", "typeof", "when", "while", "typealias", "public", "private", "internal", "inline", "open", "expect",
                "actual", "override", "import"
            ).joinToString(separator = "|", prefix = "(", postfix = ")") {
                Regex.escape(it)
            }

            return UIKitCodeBlockConfig(
                name = "Kotlin",
                rules = listOf(
                    // 关键字匹配
                    Pair(
                        """(?<!\w)${keyword}\s""".toRegex(),
                        SpanStyle(color = colors.keywordText)
                    ),
                    // 函数调用匹配
                    Pair(
                        """(?<!\bfun)(?<!\w)(\p{L}+|\p{N}+)(?=\b*\()""".toRegex(),
                        SpanStyle(color = colors.functionCallText)
                    ),
                    // 函数声明匹配
                    Pair(
                        """(?<=\bfun)(?<!\w)(\p{L}+|\p{N}+)(?=\b*\()""".toRegex(),
                        SpanStyle(color = colors.functionDeclarationText)
                    ),
                    // 注解匹配
                    Pair(
                        """(@(\p{L}+|\p{N}+))""".toRegex(),
                        SpanStyle(color = colors.metadataText)
                    ),
                    // 字符串匹配
                    Pair(
                        """(".+")|('.+')""".toRegex(),
                        SpanStyle(color = colors.stringText)
                    ),
                    // 数字匹配
                    Pair(
                        """\d+f*""".toRegex(),
                        SpanStyle(color = colors.numberText)
                    ),
                    // 注释匹配
                    Pair(
                        """((//.*)|(/\*(.*|\n*)*\*/))""".toRegex(),
                        SpanStyle(color = colors.noteText, fontStyle = FontStyle.Italic)
                    ),
                    // 文档注释匹配
                    Pair(
                        """(/\*\*+(.*|\n*)*\*+/)""".toRegex(),
                        SpanStyle(color = colors.docNoteText)
                    )
                ),
                colors = colors
            )
        }
    }
}