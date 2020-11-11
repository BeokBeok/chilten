package com.beok.chilten.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.AnimationClockAmbient
import androidx.compose.ui.unit.dp
import com.beok.chilten.ui.pager.Pager
import com.beok.chilten.ui.pager.PagerState
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun HomeScreen() {
    Scaffold(
        bodyContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                val bannerUrls = listOf(
                    "https://m.chilten.com/upload/image/banner/2020/5faa1e566f6dd1emo8d0do.jpg",
                    "https://m.chilten.com/upload/image/banner/2020/5fa89f7006c921emlatjcr.jpg",
                    "https://m.chilten.com/upload/image/banner/2020/5f72c26b007ce1ejc4esfq.jpg",
                    "https://m.chilten.com/upload/image/banner/2020/5f5b01bf7e6541ehtntl0t.jpg",
                    "https://m.chilten.com/upload/image/banner/2020/5f6c416091ce51eivduoal.jpg",
                    "https://m.chilten.com/upload/image/banner/2020/5f9e054bc27b31em0k9c0k.jpg"
                )
                HomeBanner(bannerUrls = bannerUrls)
            }
        }
    )
}

@Composable
private fun HomeBanner(
    pagerState: PagerState = run {
        val clock = AnimationClockAmbient.current
        remember(clock) {
            PagerState(clock)
        }
    },
    bannerUrls: List<String>
) {
    pagerState.maxPage = bannerUrls.size - 1

    Pager(state = pagerState) {
        Column(modifier = Modifier.padding(16.dp)) {
            Box(modifier = Modifier.weight(1f)) {
                CoilImage(
                    data = bannerUrls[page],
                    modifier = Modifier.clip(MaterialTheme.shapes.medium)
                )
            }
        }
    }

    Spacer(Modifier.height(16.dp))
}
