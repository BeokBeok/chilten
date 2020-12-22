package com.beok.chilten.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@Composable
fun makeVectorAssetList(idList: List<Int>): List<ImageVector> {
    if (idList.isNullOrEmpty()) return emptyList()

    return mutableListOf<ImageVector>()
        .apply { idList.forEach { this.add(vectorResource(id = it)) } }
        .toList()
}
