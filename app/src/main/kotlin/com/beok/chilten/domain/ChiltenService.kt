package com.beok.chilten.domain

import com.beok.chilten.domain.banner.BannerRequest
import com.beok.chilten.domain.banner.BannerResponse
import com.beok.chilten.domain.freedomboard.FreedomBoardResponse
import com.beok.chilten.domain.freedomboard.Params
import retrofit2.http.Body
import retrofit2.http.POST

interface ChiltenService {

    @POST("banner/info")
    suspend fun fetchBanner(@Body location: BannerRequest): BannerResponse

    @POST("board/home/list")
    suspend fun fetchFreedomBoard(@Body freedomBoardRequest: Params): FreedomBoardResponse
}
