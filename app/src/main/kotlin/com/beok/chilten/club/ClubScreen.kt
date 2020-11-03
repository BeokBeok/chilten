package com.beok.chilten.club

import androidx.compose.foundation.Text
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun ClubScreen() {
    Scaffold(
        bodyContent = {
            Text(text = "클럽")
        }
    )
}