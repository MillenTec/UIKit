#!/usr/bin/env kotlin

import java.io.File

var files: Array<File>? = File("../commonMain/kotlin/com/millentec/compose/uikit/symbols/uikitsymbols/regular/dp20").listFiles {
    it.isFile && it.extension == "kt"
}

files?.forEach { file ->
    val fileContent = file.readText()
    val importAddedString = """import\s+.+""".toRegex().replace(fileContent) {
        if (it.next() == null) {
            """
                ${it.value}
                import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbolLayerInfo
            """.trimIndent()
        } else it.value
    }

    println("imported UIKitSymbolLayerInfo in '${file.name}.'")

    val paths = """path\(\s*fill""".toRegex().findAll(importAddedString)

    println("found ${paths.count()} paths.")

    var layers: String = ""
    paths.forEachIndexed { index, result ->
        layers += """
        UIKitSymbolLayerInfo(
            description = ${
            when (index) {
                0 -> "\"Primary\""
                1 -> "\"Secondary\""
                2 -> "\"Tertiary\""
                3 -> "\"Fourth\""
                4 -> "\"Fifth\""
                else -> "TODO()"
            }
        },
            expectAlpha = ${
            if (paths.count() == 2) {
                when (index) {
                    0 -> "1f"
                    1 -> "0.6f"
                    else -> "TODO()"
                }
            } else {
                when (index) {
                    0 -> "1f"
                    1 -> "0.75f"
                    2 -> "0.6f"
                    3 -> "0.45f"
                    4 -> "0.3f"
                    else -> "TODO()"
                }
            }
        }
        )${if (index == paths.count() - 1) "" else ","}
        """.trimIndent()
    }

    val parameterAddedString = """(return\s+object\s*:\s*UIKitStaticSymbol\(\s*)(name\s*=\s*.+\s*defaultSize\s*=\s*.+\s*brushes\s*=\s*.+)""".toRegex().replace(importAddedString) {
        println(it.value)
        """${it.groupValues[1]}
           ${it.groupValues[2]},
           layers = listOf(
               ${if (layers.isNotEmpty()) layers else "TODO()"}
           )
        """.trimIndent()
    }

    file.writeText(parameterAddedString, Charsets.UTF_8)

    println("Modified ${file.name}")
}