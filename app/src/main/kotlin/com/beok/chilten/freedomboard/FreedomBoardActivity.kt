package com.beok.chilten.freedomboard

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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
                                FreedomBoardDetailActivity.BUNDLE_BOARD_IDX to boardIdx,
                                FreedomBoardDetailActivity.BUNDLE_POST_IDX to postIdx
                            )
                        )
                    }
                )
        }

        viewModel.fetchFreedomBoard()
    }
}
