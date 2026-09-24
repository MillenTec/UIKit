#!/usr/bin/env kotlin

import java.io.File

val fileBuilder = StringBuilder()
fileBuilder.appendLine("package com.millentec.compose.uikit")
fileBuilder.appendLine()
fileBuilder.appendLine("import com.millentec.compose.uikit.symbols.UIKitSymbols")

val walk = File("../../../uikitMain/src/commonMain/kotlin/com/millentec/compose/uikit/symbols/builtin")
    .walk()
    .filter { it.isDirectory && it.name != "builtin" }

walk.forEach { dir ->
    val calls = dir.path.removePrefix(File("../../../uikitMain/src/commonMain/kotlin/com/millentec/compose/uikit/symbols/builtin").path)
        .removePrefix("/")
        .removePrefix("\\")
        .split("/", "\\")
    var callStr = ""
    calls.forEachIndexed { index, string ->
        callStr += string
        if (index != calls.size - 1) callStr += "."
    }
    fileBuilder.appendLine("import com.millentec.compose.uikit.symbols.builtin.${callStr}.*")
}

fileBuilder.appendLine()

walk.forEach { dir ->
    val symbols = dir.walk().filter { it.isFile && it.extension == "kt" }
    val builder = StringBuilder()
    val calls = dir.path.removePrefix(File("../../../uikitMain/src/commonMain/kotlin/com/millentec/compose/uikit/symbols/builtin").path)
        .removePrefix("/")
        .removePrefix("\\")
        .split("/", "\\").map {
            when (it) {
                "systemui" -> "systemUI"
                else -> it
            }
        }

    if (calls.size == 1) {
        symbols.forEachIndexed { index, symbol ->
            val calls =
                symbol.parent.removePrefix(File("../../../uikitMain/src/commonMain/kotlin/com/millentec/compose/uikit/symbols/builtin").path)
                    .removePrefix("/")
                    .removePrefix("\\")
                    .split("/", "\\").map {
                        when (it) {
                            "systemui" -> "systemUI"
                            else -> it
                        }
                    }
            var callStr = ""
            calls.forEachIndexed { index, string ->
                callStr += string
                if (index != calls.size - 1) callStr += "."
            }
            builder.appendLine("UIKitSymbols.$callStr.${symbol.nameWithoutExtension}${if (index == symbols.count() - 1) "" else ","}")
            println("Added '${symbol.nameWithoutExtension}'.")
        }

        val string = """
val ${
            when (dir.name) {
                "systemui" -> "systemUI"
                else -> dir.name
            }.replaceFirstChar { char ->
                if (char.isLowerCase()) char.uppercaseChar() else char
            }
        }Symbols = listOf(
        $builder
)
    """.trimIndent()

        fileBuilder.append(string)
        fileBuilder.appendLine()
    }
}

val file = File("../commonMain/kotlin/com/millentec/compose/uikit/SymbolList.g.kt")
if (file.exists()) {
    file.writeText(fileBuilder.toString())
} else {
    file.createNewFile()
    file.writeText(fileBuilder.toString())
}