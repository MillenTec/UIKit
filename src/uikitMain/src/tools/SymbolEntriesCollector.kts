#!/usr/bin/env kotlin

/*
 * AIGC: 使用了人工智能编写了预构建脚本
 * - Time: 2026-11-08 11:35
 * - Model: GLM 5.3 Flash
 * - Harness: ZCode
 * - State: Unreviewed
 */

/**
 * UIKitSymbolEntries 预构建脚本。
 *
 * 扫描 `symbols/builtin` 下的全部内置图标源码, 提取扩展属性声明
 * (`val UIKit*Symbols[.UIKit*FilledSymbols].Name: UIKitSymbol`) 与 `uid`,
 * 为 UIKitSymbols (根) 及其所有 UIKit*Symbols 子集生成 `entries` 扩展属性,
 * 输出到 `symbols/UIKitSymbolEntries.g.kt`。
 *
 * 新增图标 / 图标子集后重新运行本脚本即可, 无需手动维护 entries。
 *
 * 运行方式 (须从本目录运行, 同 IconCollector.kts):
 * ```
 * kotlin SymbolEntriesCollector.kts
 * ```
 *
 * 识别约定:
 * - 池注册 (根子集): `UIKitSymbolPool` 类体内 `val <prop> = UIKit<X>Symbols(this)`
 * - 嵌套注册: `UIKit*Symbols` 子集类体内 `val <prop> = UIKit<Y>Symbols(...)`
 * - 图标: `builtin/` 内源文件中的 `val UIKit<X>Symbols[.UIKit<Y>Symbols].<Name>: UIKitSymbol`
 *   声明, 以及其后第一个 `uid = "..."`; 与图标所在目录结构无关
 * - 子集 entries 包含其嵌套子树的全部符号; 无图标的子集不会生成 entries
 * - 嵌套子集类为嵌套类, 生成声明时须以外层类限定接收者类型:
 *   `val UIKitMediaSymbols.UIKitMediaFilledSymbols.entries`
 * - entries 内容与具体 pool 实例无关 (pool 是 UIKitSymbolSet 各方法的入参),
 *   故每个 scope 以文件私有 `by lazy` 单例缓存, 避免每次访问重建
 */

import java.io.File
import java.time.LocalDateTime

// ---------------------------------------------------------------------------
// 路径 (相对本目录, 即 src/uikitMain/src/tools)
// ---------------------------------------------------------------------------
val symbolsDir = File("../commonMain/kotlin/com/millentec/compose/uikit/symbols")
val builtinDir = File(symbolsDir, "builtin")
val outputFile = File(symbolsDir, "UIKitSymbolEntries.g.kt")

require(symbolsDir.isDirectory) {
    "未找到 symbols 目录 (${symbolsDir.absolutePath}), 请从 src/uikitMain/src/tools 目录运行本脚本"
}
require(builtinDir.isDirectory) { "未找到 builtin 目录 (${builtinDir.absolutePath})" }

// ---------------------------------------------------------------------------
// 1. 解析子集注册表: 类名 -> (池导航属性名, 父类名)
//    根子集 (parent == null) 注册于 UIKitSymbolPool/UIKitSymbols 类体上下文;
//    嵌套子集注册于其它 UIKit*Symbols 类体上下文。
//    上下文通过大括号深度跟踪确定 (依赖标准 ktlint 风格排版, 且类声明行
//    与其类体 `{` 之间不存在其它会开括号的结构)。
// ---------------------------------------------------------------------------
data class SubsetRegistration(val prop: String, val parent: String?)

val rootContexts = setOf("UIKitSymbolPool", "UIKitSymbols")
val classDeclRegex = Regex("""\b(?:class|object)\s+(UIKit\w+)""")
val subsetInitRegex = Regex("""val\s+(\w+)\s*=\s*(UIKit\w+)\(""")

val registrations = LinkedHashMap<String, SubsetRegistration>()

symbolsDir.listFiles { file -> file.isFile && file.extension == "kt" }!!
    .sortedBy { it.name }
    .forEach { file ->
        var pendingClass: String? = null
        val contextStack = ArrayDeque<String>()
        file.readLines().forEach { raw ->
            val line = raw.substringBefore("//")
            classDeclRegex.find(line)?.let { pendingClass = it.groupValues[1] }
            subsetInitRegex.find(line)?.let { match ->
                val prop = match.groupValues[1]
                val child = match.groupValues[2]
                val context = contextStack.lastOrNull()
                when {
                    context != null && context in rootContexts ->
                        registrations[child] = SubsetRegistration(prop, null)
                    context != null && child.endsWith("Symbols") ->
                        registrations[child] = SubsetRegistration(prop, context)
                }
            }
            val opens = line.count { it == '{' }
            val closes = line.count { it == '}' }
            if (opens > 0) pendingClass?.let { contextStack.addLast(it) }
            repeat(closes) { if (contextStack.isNotEmpty()) contextStack.removeLast() }
        }
    }

require(registrations.isNotEmpty()) {
    "未在 ${symbolsDir.name} 下解析到任何子集注册 (val xxx = UIKit...Symbols(...))"
}

// ---------------------------------------------------------------------------
// 2. 扫描 builtin 中的图标声明 (递归全部子目录)
// ---------------------------------------------------------------------------
data class IconDecl(val pkg: String, val chain: List<String>, val name: String, val uid: String)

val iconDeclRegex =
    Regex("""^(?:internal\s+)?val\s+((?:UIKit\w+)(?:\.UIKit\w+)*)\.(\w+)\s*:\s*UIKitSymbol\s*$""")
val uidRegex = Regex("""uid\s*=\s*"([^"]*)"""")
val packageRegex = Regex("""^package\s+([\w.]+)""")

val icons = mutableListOf<IconDecl>()

builtinDir.walkTopDown()
    .filter { file -> file.isFile && file.extension == "kt" }
    .sortedBy { it.invariantSeparatorsPath }
    .forEach { file ->
        var pkg: String? = null
        var chain: List<String>? = null
        var name: String? = null
        var uid: String? = null

        fun flush() {
            val declaredChain = chain ?: return
            require(pkg != null) { "${file.name}: 缺少 package 声明" }
            require(!uid.isNullOrEmpty()) { "${file.name}: 扩展属性 ${declaredChain.joinToString(".")}.$name 缺少 uid 声明" }
            icons.add(IconDecl(pkg!!, declaredChain, name!!, uid!!))
            chain = null; name = null; uid = null
        }

        file.readLines().forEach { raw ->
            val line = raw.substringBefore("//").trim()
            packageRegex.find(line)?.let { pkg = it.groupValues[1] }
            iconDeclRegex.find(line)?.let { match ->
                flush()
                chain = match.groupValues[1].split('.')
                name = match.groupValues[2]
            }
            if (chain != null && uid == null) {
                uidRegex.find(line)?.let { uid = it.groupValues[1] }
            }
        }
        flush()
    }

require(icons.isNotEmpty()) { "未在 builtin 中找到任何图标扩展属性声明" }

// ---------------------------------------------------------------------------
// 3. 组装各 scope 的 entries: scope = 接收者类链 (根为空链), 内容为 uid -> 池导航路径
//    导航路径由接收者类链解析出的池属性拼接而成, 始终从池根出发
//    (UIKitSymbolSet 的 supplier 签名为 (pool: UIKitSymbolPool) -> UIKitSymbol)。
// ---------------------------------------------------------------------------
val scopes = LinkedHashMap<List<String>, LinkedHashMap<String, String>>()

icons.forEach { icon ->
    val props = icon.chain.mapIndexed { index, cls ->
        val reg = registrations[cls]
            ?: error("${icon.pkg}.${icon.name}: 接收者 $cls 未在池/子集中注册 (缺少 val xxx = $cls(...) 声明)")
        val expectedParent = icon.chain.getOrNull(index - 1)
        require(reg.parent == expectedParent) {
            "${icon.pkg}.${icon.name}: $cls 应注册于 ${expectedParent ?: "池根"} 下, 实际注册于 ${reg.parent ?: "池根"}"
        }
        reg.prop
    }
    val nav = (props + icon.name).joinToString(".")
    for (depth in 0..icon.chain.size) {
        val scopeKey = icon.chain.take(depth)
        val scope = scopes.getOrPut(scopeKey) { LinkedHashMap() }
        require(icon.uid !in scope) {
            "uid \"${icon.uid}\" 在 scope [${scopeKey.joinToString(".")}] 中重复: ${scope[icon.uid]} 与 $nav"
        }
        scope[icon.uid] = nav
    }
}

// ---------------------------------------------------------------------------
// 4. 生成代码
// ---------------------------------------------------------------------------
val sortedScopes = scopes.entries
    .sortedWith(compareBy({ it.key.size }, { it.key.joinToString(".") }))
    .toList()

// 生成声明所用的接收者类型: 嵌套子集类必须以外层类限定 (如 UIKitMediaSymbols.UIKitMediaFilledSymbols)
fun receiverOf(chain: List<String>): String = chain.joinToString(".").ifEmpty { "UIKitSymbols" }

fun hasNestedChildren(chain: List<String>): Boolean =
    scopes.keys.any { it.size > chain.size && it.take(chain.size) == chain }

val code = buildString {
    appendLine("/*")
    appendLine(" * Generated by Kotlin Script (uikitMain/src/tools/SymbolEntriesCollector.kts).")
    appendLine(" * Generation time: ${LocalDateTime.now()}")
    appendLine(" */")
    appendLine()
    appendLine("package com.millentec.compose.uikit.symbols")
    appendLine()
    icons.map { it.pkg }.distinct().sorted().forEach { appendLine("import $it.*") }
    sortedScopes.forEach { (chain, members) ->
        appendLine()
        val receiver = receiverOf(chain)
        val cacheName = "${chain.lastOrNull() ?: "UIKitSymbols"}Entries"
        val subject = if (chain.isEmpty()) "全部内置符号" else "${chain.last()} 子集符号"
        val nested = if (chain.isEmpty() || hasNestedChildren(chain)) " (含嵌套子集)" else ""
        appendLine("private val $cacheName: UIKitSymbolSet by lazy {")
        appendLine("    UIKitSymbolSet(")
        members.entries.sortedBy { it.key }.forEach { (uid, nav) ->
            appendLine("        Pair(\"$uid\") { it.$nav },")
        }
        appendLine("    )")
        appendLine("}")
        appendLine()
        appendLine("/** $subject, 共 ${members.size} 项$nested。 */")
        appendLine("val $receiver.entries: UIKitSymbolSet")
        appendLine("    get() = $cacheName")
    }
    appendLine()
}

outputFile.writeText(code)
println("已生成: ${outputFile.canonicalPath}")
println("共 ${icons.size} 个符号, ${sortedScopes.size} 个 entries:")
sortedScopes.forEach { (chain, members) ->
    println("  - ${receiverOf(chain)}: ${members.size} 项")
}
