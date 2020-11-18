package com.beok.chilten.domain

import retrofit2.http.POST

interface ChiltenService {

    @POST("banner/info")
    suspend fun fetchBanner(): BannerResponse
}