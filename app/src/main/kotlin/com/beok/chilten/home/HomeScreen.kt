package com.beok.chilten.home

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.AmbientAnimationClock
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.unit.dp
import com.beok.chilten.R
import com.beok.chilten.freedomboard.FreedomBoardActivity
import com.beok.chilten.ui.pager.Pager
import com.beok.chilten.ui.pager.PagerState
import com.beok.chilten.util.makeVectorAssetList
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val bannerUrls: List<String> by homeViewModel.bannerUrlList.observeAsState(listOf())
    Scaffold(
        bodyContent = {
            ScrollableColumn(modifier = Modifier.fillMaxSize()) {
                HomeBanner(
                    modifier = Modifier.preferredHeight(280.dp),
                    bannerUrls = bannerUrls
                )

                MiddleMenu()
            }
        }
    )
}

@Composable
private fun MiddleMenu() {
    Row {
        val context = AmbientContext.current
        makeVectorAssetList(
            idList = listOf(
                R.drawable.ic_freedom_board,
                R.drawable.ic_bowling_video,
                R.drawable.ic_used_market,
                R.drawable.ic_ranking_of_honor
            )
        ).forEachIndexed { index, vectorAsset ->
            Column(modifier = Modifier.weight(1f)) {
                IconButton(
                    onClick = {
                        when (index) {
                            1 -> Toast.makeText(context, "볼링영상", Toast.LENGTH_SHORT).show()
                            2 -> Toast.makeText(context, "중고장터", Toast.LENGTH_SHORT).show()
                            3 -> Toast.makeText(context, "명예의전당", Toast.LENGTH_SHORT).show()
                            else -> context.startActivity(
                                Intent(
                                    context,
                                    FreedomBoardActivity::class.java
                                )
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    content = { Icon(imageVector = vectorAsset) }
                )
                Text(
                    text = when (index) {
                        1 -> "볼링영상"
                        2 -> "중고장터"
                        3 -> "명예의전당"
                        else -> "자유게시판"
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
private fun HomeBanner(
    modifier: Modifier = Modifier,
    pagerState: PagerState = run {
        val clock = AmbientAnimationClock.current
        remember(clock) {
            PagerState(clock)
        }
    },
    bannerUrls: List<String>
) {
    if (bannerUrls.isEmpty()) return

    pagerState.maxPage = bannerUrls.size - 1
    Pager(
        state = pagerState,
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Box {
                CoilImage(
                    data = bannerUrls[page],
                    modifier = Modifier.clip(MaterialTheme.shapes.medium)
                )
            }
        }
    }
}
