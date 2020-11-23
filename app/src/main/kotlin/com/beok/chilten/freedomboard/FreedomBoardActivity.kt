package com.beok.chilten.freedomboard

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FreedomBoardActivity : AppCompatActivity() {

    private val viewModel by viewModels<FreedomBoardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityFreedomBoard()
                .Layout(
                    viewModel = viewModel,
                    navigationEvent = { finish() }
                )
        }

        viewModel.fetchFreedomBoard()
    }
}
