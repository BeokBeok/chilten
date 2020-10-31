package com.beok.chilten

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.beok.chilten.ui.ChiltenTheme

object ActivityMain {

    @Composable
    fun Layout() {
        ChiltenTheme {
            Column {
                Surface(modifier = Modifier.weight(1f)) {

                }
                BottomNavigationContent()
            }
        }
    }

    @Composable
    fun BottomNavigationContent(modifier: Modifier = Modifier) {
        BottomNavigation(modifier = modifier) {
            val homeAsset = loadVectorResource(id = R.drawable.ic_navi_home)
                .resource
                .resource
                .also { if (it == null) return@BottomNavigation }
            val bowlingGymAsset = loadVectorResource(id = R.drawable.ic_navi_bowling_gym)
                .resource
                .resource
                .also { if (it == null) return@BottomNavigation }
            val clubAsset = loadVectorResource(id = R.drawable.ic_navi_club)
                .resource
                .resource
                .also { if (it == null) return@BottomNavigation }
            val myBowlingAsset = loadVectorResource(id = R.drawable.ic_navi_my_bowling)
                .resource
                .resource
                .also { if (it == null) return@BottomNavigation }

            BottomNavigationItem(
                icon = {
                    Icon(asset = homeAsset!!, modifier = Modifier.size(24.dp))
                },
                selected = false,
                onClick = {
                    Unit
                },
                label = {
                    Text(text = stringResource(id = R.string.navi_home))
                }
            )
            BottomNavigationItem(
                icon = {
                    Icon(asset = bowlingGymAsset!!, modifier = Modifier.size(24.dp))
                },
                selected = false,
                onClick = {
                    Unit
                },
                label = {
                    Text(text = stringResource(id = R.string.navi_bowling_gym))
                }
            )
            BottomNavigationItem(
                icon = {
                    Icon(asset = clubAsset!!, modifier = Modifier.size(24.dp))
                },
                selected = false,
                onClick = {
                    Unit
                },
                label = {
                    Text(text = stringResource(id = R.string.navi_club))
                }
            )
            BottomNavigationItem(
                icon = {
                    Icon(asset = myBowlingAsset!!, modifier = Modifier.size(24.dp))
                },
                selected = false,
                onClick = {
                    Unit
                },
                label = {
                    Text(text = stringResource(id = R.string.navi_my_bowling))
                }
            )
        }
    }
}
