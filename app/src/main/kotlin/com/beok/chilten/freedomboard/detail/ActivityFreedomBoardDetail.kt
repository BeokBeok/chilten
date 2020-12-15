package com.beok.chilten.freedomboard.detail

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.viewinterop.AndroidView
import com.beok.chilten.ui.ChiltenTheme

class ActivityFreedomBoardDetail {

    @Composable
    fun Layout(viewModel: FreedomBoardDetailViewModel) {
        ChiltenTheme {
            FreedomBoardDetailScaffold(viewModel = viewModel)
        }
    }

    @Composable
    fun FreedomBoardDetailScaffold(viewModel: FreedomBoardDetailViewModel) {
        Scaffold(
            bodyContent = { FreedomBoardDetailContent(viewModel = viewModel) }
        )
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Composable
    fun FreedomBoardDetailContent(viewModel: FreedomBoardDetailViewModel) {
        val content = viewModel.content.observeAsState("")
        AndroidView(
            viewBlock = ::WebView
        ) { webView ->
            with(webView) {
                settings.javaScriptEnabled = true
                settings.useWideViewPort = true
                settings.minimumFontSize = 30
                setInitialScale(1)
                loadDataWithBaseURL("", content.value, "text/html", "utf-8", "")
            }
        }
    }
}

