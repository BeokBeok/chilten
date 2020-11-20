package com.beok.chilten.freedomboard

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import com.beok.chilten.ui.ChiltenTheme

class ActivityFreedomBoard {

    @Preview
    @Composable
    fun Layout(navigationEvent: () -> Unit = { Unit }) {
        ChiltenTheme {
            FreedomBoardScaffold(navigationEvent)
        }
    }

    @Composable
    fun FreedomBoardScaffold(navigationEvent: () -> Unit) {
        Scaffold(
            topBar = { FreedomBoardTopAppBar(navigationEvent) },
            bodyContent = {}
        )
    }

    @Composable
    private fun FreedomBoardTopAppBar(navigationEvent: () -> Unit) {
        TopAppBar(
            title = { Text(text = "자유게시판") },
            navigationIcon = {
                IconButton(
                    onClick = { navigationEvent.invoke() },
                    icon = { Icon(Icons.Filled.KeyboardArrowLeft) }
                )
            }
        )
    }
}
