package com.beok.chilten.ui.pager

import androidx.compose.runtime.Immutable
import androidx.compose.ui.ParentDataModifier
import androidx.compose.ui.unit.Density

@Immutable
data class PageData(val page: Int) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?): Any? = this@PageData
}