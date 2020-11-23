package com.beok.chilten.domain

import com.beok.chilten.domain.banner.BannerRequest
import com.beok.chilten.domain.banner.BannerResponse
import com.beok.chilten.domain.freedomboard.FreedomBoardResponse
import com.beok.chilten.domain.freedomboard.Params
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChiltenRepository(
    private val remoteDataSource: ChiltenRemoteDataSource
) {
    private val ioDispatcher = Dispatchers.IO

    suspend fun fetchBanner(location: BannerRequest): BannerResponse =
        withContext(ioDispatcher) {
            remoteDataSource.fetchBanner(location)
        }

    suspend fun fetchFreedomBoard(params: Params): FreedomBoardResponse =
        withContext(ioDispatcher) {
            remoteDataSource.fetchFreedomBoard(params)
        }
}
