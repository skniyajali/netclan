package com.niyaj.common.utils

fun List<String>.toDividerText(): String {
    var newText = ""

    this.forEachIndexed { index, text ->
        val divider = if (index != this.size - 1) {
            " | "
        } else ""

        newText += "$text$divider"
    }

    return newText
}