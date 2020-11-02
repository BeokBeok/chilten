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
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.beok.chilten.ui.ChiltenTheme

object ActivityMain {

    @Composable
    fun Layout() {
        ChiltenTheme {
            TopAppBar(
                title = { Unit },
                navigationIcon = {
                    Icon(
                        asset = makeVectorAssetList(idList = listOf(R.drawable.ic_toolbar_home))
                            .first()
                    )
                }
            )
            Column {
                val bottomNavigationState: MutableState<BottomNavigationType> =
                    savedInstanceState { BottomNavigationType.HOME }

                Surface(modifier = Modifier.weight(1f)) {
                    Unit
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

        val vectorAssets = mutableListOf<VectorAsset>()

        idList.forEach {
            vectorAssets.add(vectorResource(id = it))
        }
        return vectorAssets
    }
}
