package com.beok.chilten.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
fun makePainterList(idList: List<Int>): List<Painter> {
    if (idList.isNullOrEmpty()) return emptyList()

    return mutableListOf<Painter>()
        .apply { idList.forEach { this.add(painterResource(id = it)) } }
        .toList()
}
