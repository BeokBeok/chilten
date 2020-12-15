package com.beok.chilten.freedomboard.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FreedomBoardDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        const val BUNDLE_BOARD_IDX = "board_idx"
        const val BUNDLE_POST_IDX = "post_idx"
    }
}
