package com.beok.chilten

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.beok.chilten.club.ClubScreen
import com.beok.chilten.gym.GymScreen
import com.beok.chilten.home.HomeScreen
import com.beok.chilten.home.HomeViewModel
import com.beok.chilten.myinfo.MyInfoScreen
import com.beok.chilten.ui.ChiltenTheme
import com.beok.chilten.util.makeVectorAssetList

class ActivityMain {

    @Composable
    fun Layout(homeViewModel: HomeViewModel) {
        ChiltenTheme {
            ChiltenScaffold(homeViewModel = homeViewModel)
        }
    }

    @Composable
    private fun ChiltenScaffold(homeViewModel: HomeViewModel) {
        val bottomNavigationState: MutableState<BottomNavigationType> =
            rememberSaveable { mutableStateOf(BottomNavigationType.HOME) }
        Scaffold(
            topBar = { ChiltenTopAppBar() },
            bodyContent = {
                ChiltenBodyContent(
                    bottomNavigationState = bottomNavigationState,
                    homeViewModel = homeViewModel
                )
            },
            bottomBar = { BottomNavigationContent(state = bottomNavigationState) }
        )
    }

    @Composable
    private fun ChiltenBodyContent(
        bottomNavigationState: State<BottomNavigationType>,
        homeViewModel: HomeViewModel
    ) {
        when (bottomNavigationState.value) {
            BottomNavigationType.HOME -> HomeScreen(homeViewModel)
            BottomNavigationType.BOWLING_GYM -> GymScreen()
            BottomNavigationType.CLUB -> ClubScreen()
            BottomNavigationType.MY_BOWLING -> MyInfoScreen()
        }
    }

    @Composable
    private fun ChiltenTopAppBar() {
        TopAppBar(
            title = { },
            navigationIcon = {
                Icon(
                    imageVector = makeVectorAssetList(idList = listOf(R.drawable.ic_toolbar_home))
                        .first(),
                    contentDescription = null
                )
            },
            actions = {
                IconButton(
                    onClick = { },
                    content = {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = null
                        )
                    }
                )
                IconButton(
                    onClick = { },
                    content = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = null
                        )
                    }
                )
            }
        )
    }

    @Composable
    private fun BottomNavigationContent(
        modifier: Modifier = Modifier,
        state: MutableState<BottomNavigationType>
    ) {
        BottomNavigation(modifier = modifier) {
            val (normalAssets, selectAssets) = makeVectorAssetList(
                idList = listOf(
                    R.drawable.ic_navi_home,
                    R.drawable.ic_navi_bowling_gym,
                    R.drawable.ic_navi_club,
                    R.drawable.ic_navi_my_bowling
                )
            ) to makeVectorAssetList(
                idList = listOf(
                    R.drawable.ic_navi_home_select,
                    R.drawable.ic_navi_bowling_gym_select,
                    R.drawable.ic_navi_club_select,
                    R.drawable.ic_navi_my_bowling_select
                )
            )
            val naviTexts = listOf(
                R.string.navi_home,
                R.string.navi_bowling_gym,
                R.string.navi_club,
                R.string.navi_my_bowling
            )
            val iconSize = Modifier.size(24.dp)

            for (position in normalAssets.indices) {
                BottomNavigationItem(
                    icon = {
                        SetupIcon(
                            modifier = iconSize,
                            isSelect = state.value == BottomNavigationType.findByOrdinal(position),
                            normalToSelectAsset = normalAssets[position] to selectAssets[position]
                        )
                    },
                    selected = state.value == BottomNavigationType.findByOrdinal(position),
                    onClick = {
                        state.value = BottomNavigationType.findByOrdinal(position)
                    },
                    label = {
                        Text(text = stringResource(id = naviTexts[position]))
                    }
                )
            }
        }
    }

    @Composable
    private fun SetupIcon(
        modifier: Modifier = Modifier,
        isSelect: Boolean,
        normalToSelectAsset: Pair<ImageVector, ImageVector>,
    ) {
        if (isSelect) {
            Icon(
                imageVector = normalToSelectAsset.second,
                contentDescription = null,
                modifier = modifier
            )
        } else {
            Icon(
                imageVector = normalToSelectAsset.first,
                contentDescription = null,
                modifier = modifier
            )
        }
    }
}
