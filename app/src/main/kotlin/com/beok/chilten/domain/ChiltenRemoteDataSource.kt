package com.beok.chilten.domain

import com.beok.chilten.domain.banner.BannerRequest
import com.beok.chilten.domain.banner.BannerResponse
import com.beok.chilten.domain.common.Params
import com.beok.chilten.domain.freedomboard.FreedomBoardResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface ChiltenRemoteDataSource {

    val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

    suspend fun fetchBanner(location: BannerRequest): BannerResponse

    suspend fun fetchFreedomBoard(params: Params): FreedomBoardResponse
}
