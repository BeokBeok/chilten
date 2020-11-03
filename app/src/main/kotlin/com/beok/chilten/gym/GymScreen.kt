package com.beok.chilten.gym

import androidx.compose.foundation.Text
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun GymScreen() {
    Scaffold(
        bodyContent = {
            Text(text = "볼링장")
        }
    )
}