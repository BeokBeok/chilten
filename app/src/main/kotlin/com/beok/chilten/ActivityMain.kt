package com.beok.chilten

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.beok.chilten.club.ClubScreen
import com.beok.chilten.gym.GymScreen
import com.beok.chilten.home.HomeScreen
import com.beok.chilten.myinfo.MyInfoScreen
import com.beok.chilten.ui.ChiltenTheme

class ActivityMain {

    @Preview
    @Composable
    fun Layout() {
        ChiltenTheme {
            ChiltenScaffold()
        }
    }

    @Composable
    private fun ChiltenScaffold() {
        val bottomNavigationState: MutableState<BottomNavigationType> =
            savedInstanceState { BottomNavigationType.HOME }
        Scaffold(
            topBar = { ChiltenTopAppBar() },
            bodyContent = { ChiltenBodyContent(bottomNavigationState) },
            bottomBar = { BottomNavigationContent(state = bottomNavigationState) }
        )
    }

    @Composable
    private fun ChiltenBodyContent(bottomNavigationState: State<BottomNavigationType>) {
        when (bottomNavigationState.value) {
            BottomNavigationType.HOME -> HomeScreen()
            BottomNavigationType.BOWLING_GYM -> GymScreen()
            BottomNavigationType.CLUB -> ClubScreen()
            BottomNavigationType.MY_BOWLING -> MyInfoScreen()
        }
    }

    @Composable
    private fun ChiltenTopAppBar() {
        TopAppBar(
            title = { Unit },
            navigationIcon = {
                Icon(
                    asset = makeVectorAssetList(idList = listOf(R.drawable.ic_toolbar_home))
                        .first()
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
                        setupIcon(
                            iconSize = iconSize,
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
    private fun setupIcon(
        iconSize: Modifier = Modifier,
        isSelect: Boolean,
        normalToSelectAsset: Pair<VectorAsset, VectorAsset>,
    ) {
        if (isSelect) {
            Icon(asset = normalToSelectAsset.second, modifier = iconSize)
        } else {
            Icon(asset = normalToSelectAsset.first, modifier = iconSize)
        }
    }

    @Composable
    private fun makeVectorAssetList(idList: List<Int>): List<VectorAsset> {
        if (idList.isNullOrEmpty()) return emptyList()

        return mutableListOf<VectorAsset>()
            .apply { idList.forEach { this.add(vectorResource(id = it)) } }
            .toList()
    }
}
