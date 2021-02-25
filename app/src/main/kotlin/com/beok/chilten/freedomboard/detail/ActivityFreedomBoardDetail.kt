package com.beok.chilten.freedomboard.detail

import android.annotation.SuppressLint
import android.webkit.WebView
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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
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
            content = { FreedomBoardDetailContent(viewModel = viewModel) }
        )
    }

    @Composable
    fun FreedomBoardDetailContent(viewModel: FreedomBoardDetailViewModel) {
        ConstraintLayout(
            constraintSet = getConstraintSet(),
            modifier = Modifier.fillMaxSize()
        ) {
            FreedomBoardDetailHeader(viewModel = viewModel)
            FreedomBoardDetailWebContent(viewModel = viewModel)
        }
    }

    @Composable
    private fun getConstraintSet(): ConstraintSet =
        ConstraintSet {
            val subtitle = createRefFor(ID_SUBTITLE)
            val picture = createRefFor(ID_PICTURE)
            val postInfo = createRefFor(ID_POST_INFO)
            val divider = createRefFor(ID_DIVIDER)
            val webContent = createRefFor(ID_WEB_CONTENT)
            constrain(subtitle) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
            constrain(picture) {
                top.linkTo(subtitle.bottom)
                start.linkTo(subtitle.start)
            }
            constrain(postInfo) {
                start.linkTo(picture.end)
                top.linkTo(picture.top)
                bottom.linkTo(picture.bottom)
            }
            constrain(divider) {
                top.linkTo(picture.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            constrain(webContent) {
                top.linkTo(divider.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        }

    @Composable
    private fun FreedomBoardDetailHeader(viewModel: FreedomBoardDetailViewModel) {
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
            .map(viewModel.freedomBoardDetailItem) { "조회수 ${it.hit}" }
            .observeAsState("")

        Text(
            text = subtitleText.value,
            modifier = Modifier
                .layoutId(ID_SUBTITLE)
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        CoilImage(
            data = pictureUrl.value,
            contentDescription = null,
            modifier = Modifier
                .layoutId(ID_PICTURE)
                .width(74.dp)
                .height(74.dp)
                .padding(start = 20.dp, bottom = 8.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "${nickNameText.value}\n${regDateText.value} ${hitText.value}",
            modifier = Modifier
                .layoutId(ID_POST_INFO)
                .padding(start = 12.dp)
        )
        Divider(
            color = Color.Gray,
            modifier = Modifier.layoutId(ID_DIVIDER)
        )
    }

    @Composable
    private fun FreedomBoardDetailWebContent(viewModel: FreedomBoardDetailViewModel) {
        val contentHtml = Transformations
            .map(viewModel.freedomBoardDetailItem) { it.content }
            .observeAsState("")
        AndroidView(
            factory = ::WebView,
            modifier = Modifier.layoutId(ID_WEB_CONTENT)
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

    companion object {
        private const val ID_SUBTITLE = "ID_SUBTITLE"
        private const val ID_PICTURE = "ID_PICTURE"
        private const val ID_POST_INFO = "ID_POST_INFO"
        private const val ID_DIVIDER = "ID_DIVIDER"
        private const val ID_WEB_CONTENT = "ID_WEB_CONTENT"
    }
}

