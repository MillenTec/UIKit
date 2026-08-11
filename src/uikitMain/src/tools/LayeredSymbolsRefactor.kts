#!/usr/bin/env kotlin

import java.io.File

val files: Array<File>? = File("../commonMain/kotlin/com/millentec/compose/uikit/symbols/uikitsymbols/filled/dp20").listFiles {
    it.isFile && it.extension == "kt"
}

files?.forEach { file ->
    val content = file.readText()
    val matchResult = """fun UIKitSymbols.Filled.(\w+)\s*\(""".toRegex().find(content)

    val symbolName = matchResult?.groupValues?.getOrNull(1)
    if (symbolName != null) {
        println("found layered symbol '${file.name}' in filled, symbol name: '$symbolName.'")

        val vectorContentMatchResult = """return\s*(ImageVector\.Builder[\s\S]*?\.build\(\))"""
            .toRegex().find(content)

        val vectorContent = vectorContentMatchResult?.groupValues?.getOrNull(1)
        if (vectorContent != null) {
            println("found ImageVector Builder of $symbolName.")

            val replacedContent = """path\s*\(fill\s*=\s*(.+)\)\s*\{""".toRegex().replace(vectorContent) {
                val index = when (it.groupValues[1]) {
                    "primary" -> "0"
                    "secondary" -> "1"
                    "tertiary" -> "2"
                    "fourth" -> "3"
                    else -> "TODO()"
                }
                println("'${it.value}' -> 'path(fill = brushes.getOrNull($index)) {'")
                "path(fill = brushes.getOrNull($index)) {"
            }

            val thirdOverloadContent = """fun UIKitSymbols.Filled.$symbolName\(\s*color\s*:\s*Color,\s*layered\s*:\s*Boolean\s*=\s*false[\s\S]*""".toRegex().find(content)?.value

            if (thirdOverloadContent != null) {
                println("found third overload of $symbolName.")

                val thirdOverloadReturn = """return $symbolName\(\s*([\s\S]*)\)\s*\}""".toRegex().find(thirdOverloadContent)?.groupValues?.getOrNull(1)

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
                    
                    fun UIKitFilledSymbols.$symbolName(
                        brushes: List<Brush>
                    ): UIKitStaticSymbol {
                        return object: UIKitStaticSymbol(
                            name = "${symbolName.replaceFirstChar { char -> 
                                if (char.isLowerCase()) char.uppercaseChar() else char 
                            }}",
                            defaultSize = DpSize(20.dp, 20.dp),
                            brushes = brushes
                        ) {
                            override fun builder(): ImageVector {
                                val brushes = this.brushes
                                return $replacedContent
                            }
                        }
                    }
                    
                    fun UIKitFilledSymbols.$symbolName(
                        color: Color,
                        layered: Boolean = false
                    ) = $symbolName(
                        listOf(
                            $thirdOverloadReturn
                        )
                    )
                """.trimIndent()

                file.writeText(builtString, Charsets.UTF_8)

                println("Modified ${file.name}")
                println()
            }
        }
    }
}