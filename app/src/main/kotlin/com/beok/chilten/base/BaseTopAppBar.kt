package com.beok.chilten.base

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable

@Composable
fun BaseTopAppBar(title: String = "", navigationEvent: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(
                onClick = { navigationEvent.invoke() },
                content = { Icon(Icons.Filled.KeyboardArrowLeft) }
            )
        }
    )
}
