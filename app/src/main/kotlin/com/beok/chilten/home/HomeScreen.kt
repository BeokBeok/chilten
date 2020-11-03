package com.beok.chilten.home

import androidx.compose.foundation.Text
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Scaffold(
        bodyContent = {
            Text(text = "홈")
        }
    )
}