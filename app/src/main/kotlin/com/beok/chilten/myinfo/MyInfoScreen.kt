package com.beok.chilten.myinfo

import androidx.compose.foundation.Text
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun MyInfoScreen() {
    Scaffold(
        bodyContent = {
            Text(text = "나의 볼링")
        }
    )
}