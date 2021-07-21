package com.beok.chilten.freedomboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.beok.chilten.base.BaseTopAppBar
import com.beok.chilten.ui.ChiltenTheme

@ExperimentalCoilApi
class ActivityFreedomBoard {

    @Composable
    fun Layout(
        viewModel: FreedomBoardViewModel,
        navigationEvent: () -> Unit = { },
        activityStartEvent: (boardIdx: Int, postIdx: Int) -> Unit = { _, _ -> }
    ) {
        ChiltenTheme {
            FreedomBoardScaffold(
                viewModel = viewModel,
                navigationEvent = navigationEvent,
                activityStartEvent = activityStartEvent,
            )
        }
    }

    @Composable
    fun FreedomBoardScaffold(
        viewModel: FreedomBoardViewModel,
        navigationEvent: () -> Unit,
        activityStartEvent: (boardIdx: Int, postIdx: Int) -> Unit
    ) {
        Scaffold(
            topBar = { BaseTopAppBar(title = "자유게시판", navigationEvent = navigationEvent) },
            content = { FreedomBoardContent(viewModel, activityStartEvent) }
        )
    }

    @Composable
    private fun FreedomBoardContent(
        viewModel: FreedomBoardViewModel,
        activityStartEvent: (boardIdx: Int, postIdx: Int) -> Unit
    ) {
        val freedomBoardList = viewModel.freedomBoardList.observeAsState(listOf())

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
        ) {
            itemsIndexed(freedomBoardList.value) { index, item ->
                if (index + 1 == viewModel.getFreedomBoardCount()) {
                    viewModel.fetchFreedomBoard(viewModel.getCurrentPage() + 1)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable(onClick = {
                            activityStartEvent.invoke(item.boardIdx, item.postIdx)
                        }),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FreedomThumbnail(item)
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = item.title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Text(text = "${item.nickName} ${item.registerDate}", fontSize = 12.sp)
                        Text(text = "조회 ${item.hit}", fontSize = 12.sp)
                    }
                }
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Gray
                )
            }
        }
    }

    @Composable
    private fun FreedomThumbnail(item: FreedomBoardItem) {
        if (item.imageUrl.isNotEmpty()) {
            Box(modifier = Modifier
                .width(72.dp)
                .height(72.dp)) {
                Image(
                    painter = rememberImagePainter(data = item.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.medium)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}
