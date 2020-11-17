package com.beok.chilten.freedomboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent

class FreedomBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityFreedomBoard().Layout(navigationEvent = { finish() })
        }
    }
}
