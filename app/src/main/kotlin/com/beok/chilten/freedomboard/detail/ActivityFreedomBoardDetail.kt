package com.beok.chilten.freedomboard.detail

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Transformations
import com.beok.chilten.base.BaseTopAppBar
import com.beok.chilten.ui.ChiltenTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class ActivityFreedomBoardDetail {

    @Composable
    fun Layout(
        viewModel: FreedomBoardDetailViewModel,
        navigationEvent: () -> Unit = { }
    ) {
        ChiltenTheme {
            FreedomBoardDetailScaffold(viewModel = viewModel, navigationEvent = navigationEvent)
        }
    }

    @Composable
    fun FreedomBoardDetailScaffold(
        viewModel: FreedomBoardDetailViewModel,
        navigationEvent: () -> Unit
    ) {
        Scaffold(
            topBar = { BaseTopAppBar(navigationEvent = navigationEvent) },
            bodyContent = { FreedomBoardDetailContent(viewModel = viewModel) }
        )
    }

    @Composable
    fun FreedomBoardDetailContent(viewModel: FreedomBoardDetailViewModel) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (subtitle, picture, postInfo, divider, webContent) = createRefs()
            val subtitleText = Transformations
                .map(viewModel.freedomBoardDetailItem) { it.title }
                .observeAsState("")
            val pictureUrl = Transformations
                .map(viewModel.freedomBoardDetailItem) { it.picture }
                .observeAsState("")
            val nickNameText = Transformations
                .map(viewModel.freedomBoardDetailItem) { it.nickName }
                .observeAsState("")
            val regDateText = Transformations
                .map(viewModel.freedomBoardDetailItem) { it.regDate }
                .observeAsState("")
            val hitText = Transformations
                .map(viewModel.freedomBoardDetailItem) { it.hit }
                .observeAsState("")
            val contentHtml = Transformations
                .map(viewModel.freedomBoardDetailItem) { it.content }
                .observeAsState("")
            Text(
                text = subtitleText.value,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                    .constrainAs(subtitle) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            CoilImage(
                data = pictureUrl.value,
                modifier = Modifier
                    .width(74.dp)
                    .height(74.dp)
                    .padding(start = 20.dp, bottom = 8.dp)
                    .constrainAs(picture) {
                        top.linkTo(subtitle.bottom)
                        start.linkTo(subtitle.start)
                    },
                contentScale = ContentScale.Crop
            )
            Text(
                text = "${nickNameText.value}\n${regDateText.value}  조회수 ${hitText.value}",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .constrainAs(postInfo) {
                        start.linkTo(picture.end)
                        top.linkTo(picture.top)
                        bottom.linkTo(picture.bottom)
                    }
            )
            Divider(
                modifier = Modifier
                    .constrainAs(divider) {
                        top.linkTo(picture.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                color = Color.Gray
            )
            AndroidView(
                viewBlock = ::WebView,
                modifier = Modifier.constrainAs(webContent) {
                    top.linkTo(divider.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) { webView ->
                with(webView) {
                    @SuppressLint("SetJavaScriptEnabled")
                    settings.javaScriptEnabled = true
                    settings.useWideViewPort = true
                    settings.minimumFontSize = 30
                    setInitialScale(1)
                    loadDataWithBaseURL("", contentHtml.value, "text/html", "utf-8", "")
                }
            }
        }
    }
}

