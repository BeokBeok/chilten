package com.beok.chilten.domain

import com.beok.chilten.domain.banner.BannerRequest
import com.beok.chilten.domain.banner.BannerResponse
import com.beok.chilten.domain.freedomboard.FreedomBoardResponse
import com.beok.chilten.domain.freedomboard.Params
import kotlinx.coroutines.withContext

class ChiltenRemoteDataSourceImpl(
    private val chiltenService: ChiltenService
) : ChiltenRemoteDataSource {

    override suspend fun fetchBanner(location: BannerRequest): BannerResponse =
        withContext(ioDispatcher) {
            chiltenService.fetchBanner(location)
        }

    override suspend fun fetchFreedomBoard(params: Params): FreedomBoardResponse =
        withContext(ioDispatcher) {
            chiltenService.fetchFreedomBoard(params)
        }
}
