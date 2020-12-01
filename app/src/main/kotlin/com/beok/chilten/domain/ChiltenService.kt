package com.beok.chilten.domain

import com.beok.chilten.domain.banner.BannerRequest
import com.beok.chilten.domain.banner.BannerResponse
import com.beok.chilten.domain.comment.CommentResponse
import com.beok.chilten.domain.common.Params
import com.beok.chilten.domain.freedomboard.FreedomBoardResponse
import com.beok.chilten.domain.freedomboard.detail.FreedomBoardDetailResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ChiltenService {

    @POST("banner/info")
    suspend fun fetchBanner(@Body location: BannerRequest): BannerResponse

    @POST("board/home/list")
    suspend fun fetchFreedomBoard(@Body freedomBoardRequest: Params): FreedomBoardResponse

    @POST("board/detail")
    suspend fun fetchFreedomBoardDetail(@Body freedomBoardRequest: Params): FreedomBoardDetailResponse

    @POST("comment/list")
    suspend fun fetchCommentList(@Body commentRequest: Params): CommentResponse
}
