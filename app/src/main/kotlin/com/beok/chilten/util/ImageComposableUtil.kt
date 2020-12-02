package com.beok.chilten.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.vectorResource

@Composable
fun makeVectorAssetList(idList: List<Int>): List<VectorAsset> {
    if (idList.isNullOrEmpty()) return emptyList()

    return mutableListOf<VectorAsset>()
        .apply { idList.forEach { this.add(vectorResource(id = it)) } }
        .toList()
}
