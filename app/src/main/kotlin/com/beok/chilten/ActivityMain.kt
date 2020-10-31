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
import androidx.compose.ui.graphics.vector.VectorAssetBuilder
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.beok.chilten.ui.ChiltenTheme

object ActivityMain {

    private const val DEFAULT_VECTOR_ASSET_NAME = "default"
    private const val DEFAULT_ICON_SIZE = 24

    @Composable
    fun Layout() {
        ChiltenTheme {
            val bottomNavigationState: MutableState<BottomNavigationType> =
                savedInstanceState { BottomNavigationType.HOME }
            Column {
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
            val iconSize = Modifier.size(24.dp)

            BottomNavigationItem(
                icon = {
                    setupIcon(
                        iconSize = iconSize,
                        isSelect = state.value == BottomNavigationType.HOME,
                        normalToSelectAsset = normalAssets[0] to selectAssets[0]
                    )
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
                    setupIcon(
                        iconSize = iconSize,
                        isSelect = state.value == BottomNavigationType.BOWLING_GYM,
                        normalToSelectAsset = normalAssets[1] to selectAssets[1]
                    )
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
                    setupIcon(
                        iconSize = iconSize,
                        isSelect = state.value == BottomNavigationType.CLUB,
                        normalToSelectAsset = normalAssets[2] to selectAssets[2]
                    )
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
                    setupIcon(
                        iconSize = iconSize,
                        isSelect = state.value == BottomNavigationType.MY_BOWLING,
                        normalToSelectAsset = normalAssets[3] to selectAssets[3]
                    )
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
        val defaultVectorAsset = VectorAssetBuilder(
            name = DEFAULT_VECTOR_ASSET_NAME,
            defaultWidth = DEFAULT_ICON_SIZE.dp,
            defaultHeight = DEFAULT_ICON_SIZE.dp,
            viewportWidth = DEFAULT_ICON_SIZE.toFloat(),
            viewportHeight = DEFAULT_ICON_SIZE.toFloat()
        )
            .build()

        idList.forEach {
            vectorAssets.add(
                loadVectorResource(id = it)
                    .resource
                    .resource
                    ?: defaultVectorAsset
            )
        }
        return vectorAssets
    }
}
