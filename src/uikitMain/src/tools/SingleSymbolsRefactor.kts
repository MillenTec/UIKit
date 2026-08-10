#!/usr/bin/env kotlin

import java.io.File

// 此脚本将会将所有旧单层图标 (ImageVector) 转换新式图标 (UIKitSymbol)

val files: Array<File>? = File("../commonMain/kotlin/com/millentec/compose/uikit/symbols/uikitsymbols/filled/dp20").listFiles {
    it.isFile && it.extension == "kt"
}

files?.forEach { file ->
    val content = file.readText()
    val matchResult = """val UIKitSymbols.Filled.(\w+): ImageVector""".toRegex().find(content)

    val symbolName = matchResult?.groupValues?.getOrNull(1)
    if (symbolName != null) {
        println("found single symbol '${file.name}' in filled, symbol name: '$symbolName.'")

        val vectorContentMatchResult = """_$symbolName\s*=\s*(ImageVector\.Builder[\s\S]*?\.build\(\))"""
            .toRegex().find(content)

        val vectorContent = vectorContentMatchResult?.groupValues?.getOrNull(1)
        if (vectorContent != null) {
            println("found ImageVector Builder of $symbolName.")

            val replacedContent = """path\s*\(fill\s*=\s*(.+)\)\s*\{""".toRegex().replace(vectorContent) {
                println("'${it.value}' -> 'path(fill = brushes.getOrNull(0)) {'")
                "path(fill = brushes.getOrNull(0)) {"
            }

            if (replacedContent.isNotEmpty()) {
                val builtString = """
                    package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

                    import androidx.compose.ui.graphics.Brush
                    import androidx.compose.ui.graphics.Color
                    import androidx.compose.ui.graphics.SolidColor
                    import androidx.compose.ui.graphics.vector.ImageVector
                    import androidx.compose.ui.graphics.vector.path
                    import androidx.compose.ui.unit.DpSize
                    import androidx.compose.ui.unit.dp
                    import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitFilledSymbols
                    import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitStaticSymbol
                    
                    fun UIKitFilledSymbols.${symbolName.replaceFirstChar { char ->
                    if (char.isUpperCase()) char.lowercaseChar() else char
                }}(
                        brush: Brush
                    ): UIKitStaticSymbol {
                        return object : UIKitStaticSymbol(
                            name = "$symbolName",
                            defaultSize = DpSize(20.dp, 20.dp),
                            brushes = listOf(brush)
                        ) {
                            override fun builder(): ImageVector {
                                return $replacedContent
                            }
                        }
                    }
                    
                    fun UIKitFilledSymbols.${
                    symbolName.replaceFirstChar { char ->
                        if (char.isUpperCase()) char.lowercaseChar() else char
                    }
                }(
                        color: Color
                 ) = ${
                    symbolName.replaceFirstChar { char ->
                        if (char.isUpperCase()) char.lowercaseChar() else char
                    }
                }(
                    SolidColor(color)
                )
                """.trimIndent()

                file.writeText(builtString, Charsets.UTF_8)

                println("Modified ${file.name}")
            }
        }
    }

    println()
}