package com.beok.chilten

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.annotation.ExperimentalCoilApi
import com.beok.chilten.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityMain().Layout(homeViewModel = homeViewModel)
        }

        homeViewModel.fetchBannerUrlList()
    }
}
