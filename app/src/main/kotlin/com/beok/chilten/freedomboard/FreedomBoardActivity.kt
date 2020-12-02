package com.beok.chilten.freedomboard

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import androidx.core.os.bundleOf
import com.beok.chilten.ext.startActivity
import com.beok.chilten.freedomboard.detail.FreedomBoardDetailActivity
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
                    navigationEvent = { finish() },
                    activityStartEvent = { boardIdx, postIdx ->
                        startActivity<FreedomBoardDetailActivity>(
                            bundleOf(
                                BUNDLE_BOARD_IDX to boardIdx,
                                BUNDLE_POST_IDX to postIdx
                            )
                        )
                    }
                )
        }

        viewModel.fetchFreedomBoard()
    }

    companion object {
        private const val BUNDLE_BOARD_IDX = "board_idx"
        private const val BUNDLE_POST_IDX = "post_idx"
    }
}
