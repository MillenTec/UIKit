package cn.longzhengyi.windowsdecoration.windowhelper.utils

import java.util.concurrent.atomic.AtomicInteger


// ─── 自动 ID 分配 ───

private val autoIdCounter = AtomicInteger(0)

/**
 * 为区域注册生成全局唯一的自动 ID。
 *
 * 提取为统一函数，便于后续调整 ID 分配算法（如改用 UUID、层级命名等）。
 *
 * @param prefix 前缀，用于区分区域类型（如 `"caption"`、`"interactive"`）
 * @return 格式为 `"{prefix}-auto-{序号}"` 的唯一 ID
 */
internal fun generateAutoId(prefix: String): String =
    "$prefix-auto-${autoIdCounter.incrementAndGet()}"
