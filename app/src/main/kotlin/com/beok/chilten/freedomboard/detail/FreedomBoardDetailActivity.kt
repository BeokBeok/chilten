package com.beok.chilten.freedomboard.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FreedomBoardDetailActivity : AppCompatActivity() {

    private val viewModel by viewModels<FreedomBoardDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityFreedomBoardDetail()
                .Layout(
                    viewModel = viewModel,
                    navigationEvent = { finish() },
                )
        }

        viewModel.fetchFreedomBoardDetail(
            boardIdx = intent.getIntExtra(BUNDLE_BOARD_IDX, 0),
            postIdx = intent.getIntExtra(BUNDLE_POST_IDX, 0)
        )
    }

    companion object {
        const val BUNDLE_BOARD_IDX = "board_idx"
        const val BUNDLE_POST_IDX = "post_idx"
    }
}
