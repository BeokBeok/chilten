package com.beok.chilten

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.beok.chilten.ui.ChiltenTheme

object ActivityMain {

    @Composable
    fun Layout() {
        ChiltenTheme {
            val bottomNavigationState: MutableState<BottomNavigationType> =
                savedInstanceState { BottomNavigationType.HOME }
            Column {
                Surface(modifier = Modifier.weight(1f)) {

                }
                BottomNavigationContent(state = bottomNavigationState)
            }
        }
    }

    @Composable
    fun BottomNavigationContent(
        modifier: Modifier = Modifier,
        state: MutableState<BottomNavigationType>
    ) {
        BottomNavigation(modifier = modifier) {
            val (homeAsset, homeSelectAsset) =
                loadVectorResource(id = R.drawable.ic_navi_home)
                    .resource
                    .resource
                    .also { if (it == null) return@BottomNavigation } to
                        loadVectorResource(id = R.drawable.ic_navi_home_select)
                            .resource
                            .resource
                            .also { if (it == null) return@BottomNavigation }
            val (bowlingGymAsset, bowlingGymSelectAsset) =
                loadVectorResource(id = R.drawable.ic_navi_bowling_gym)
                    .resource
                    .resource
                    .also { if (it == null) return@BottomNavigation } to
                        loadVectorResource(id = R.drawable.ic_navi_bowling_gym_select)
                            .resource
                            .resource
                            .also { if (it == null) return@BottomNavigation }
            val (clubAsset, clubSelectAsset) =
                loadVectorResource(id = R.drawable.ic_navi_club)
                    .resource
                    .resource
                    .also { if (it == null) return@BottomNavigation } to
                        loadVectorResource(id = R.drawable.ic_navi_club_select)
                            .resource
                            .resource
                            .also { if (it == null) return@BottomNavigation }
            val (myBowlingAsset, myBowlingSelectAsset) =
                loadVectorResource(id = R.drawable.ic_navi_my_bowling)
                    .resource
                    .resource
                    .also { if (it == null) return@BottomNavigation } to
                        loadVectorResource(id = R.drawable.ic_navi_my_bowling_select)
                            .resource
                            .resource
                            .also { if (it == null) return@BottomNavigation }

            BottomNavigationItem(
                icon = {
                    if (state.value == BottomNavigationType.HOME) {
                        Icon(asset = homeSelectAsset!!, modifier = Modifier.size(24.dp))
                    } else {
                        Icon(asset = homeAsset!!, modifier = Modifier.size(24.dp))
                    }
                },
                selected = state.value == BottomNavigationType.HOME,
                onClick = {
                    state.value = BottomNavigationType.HOME
                },
                label = {
                    Text(text = stringResource(id = R.string.navi_home))
                }
            )
            BottomNavigationItem(
                icon = {
                    if (state.value == BottomNavigationType.BOWLING_GYM) {
                        Icon(asset = bowlingGymSelectAsset!!, modifier = Modifier.size(24.dp))
                    } else {
                        Icon(asset = bowlingGymAsset!!, modifier = Modifier.size(24.dp))
                    }
                },
                selected = state.value == BottomNavigationType.BOWLING_GYM,
                onClick = {
                    state.value = BottomNavigationType.BOWLING_GYM
                },
                label = {
                    Text(text = stringResource(id = R.string.navi_bowling_gym))
                }
            )
            BottomNavigationItem(
                icon = {
                    if (state.value == BottomNavigationType.CLUB) {
                        Icon(asset = clubSelectAsset!!, modifier = Modifier.size(24.dp))
                    } else {
                        Icon(asset = clubAsset!!, modifier = Modifier.size(24.dp))
                    }
                },
                selected = state.value == BottomNavigationType.CLUB,
                onClick = {
                    state.value = BottomNavigationType.CLUB
                },
                label = {
                    Text(text = stringResource(id = R.string.navi_club))
                }
            )
            BottomNavigationItem(
                icon = {
                    if (state.value == BottomNavigationType.MY_BOWLING) {
                        Icon(asset = myBowlingSelectAsset!!, modifier = Modifier.size(24.dp))
                    } else {
                        Icon(asset = myBowlingAsset!!, modifier = Modifier.size(24.dp))
                    }
                },
                selected = state.value == BottomNavigationType.MY_BOWLING,
                onClick = {
                    state.value = BottomNavigationType.MY_BOWLING
                },
                label = {
                    Text(text = stringResource(id = R.string.navi_my_bowling))
                }
            )
        }
    }
}
