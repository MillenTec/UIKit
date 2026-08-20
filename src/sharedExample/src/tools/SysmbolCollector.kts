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
    fileBuilder.appendLine("import com.millentec.compose.uikit.symbols.builtin.${dir.name}.*")
}

fileBuilder.appendLine()

walk.forEach { dir ->
    val call = when(dir.name) {
        "systemui" -> "systemUI"
        else -> dir.name
    }

    val symbols = dir.walk().filter { it.isFile && it.extension == "kt" }
    val builder = StringBuilder()
    symbols.forEachIndexed { index, symbol ->
        builder.appendLine("UIKitSymbols.$call.${symbol.nameWithoutExtension}${if (index == symbols.count() - 1) "" else ","}")
        println("Added '${symbol.nameWithoutExtension}'.")
    }

    val string = """
val ${call.replaceFirstChar { char ->
        if (char.isLowerCase()) char.uppercaseChar() else char
    }}Symbols = listOf(
        $builder
)
    """.trimIndent()

    fileBuilder.append(string)
    fileBuilder.appendLine()
}

val file = File("../commonMain/kotlin/com/millentec/compose/uikit/SymbolList.g.kt")
if (file.exists()) {
    file.writeText(fileBuilder.toString())
} else {
    file.createNewFile()
    file.writeText(fileBuilder.toString())
}