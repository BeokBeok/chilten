package com.beok.chilten.domain

import com.beok.chilten.domain.banner.BannerRequest
import com.beok.chilten.domain.banner.BannerResponse
import com.beok.chilten.domain.comment.CommentResponse
import com.beok.chilten.domain.common.Params
import com.beok.chilten.domain.freedomboard.FreedomBoardResponse
import com.beok.chilten.domain.freedomboard.detail.FreedomBoardDetailResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface ChiltenRemoteDataSource {

    val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

    suspend fun fetchBanner(location: BannerRequest): BannerResponse

    suspend fun fetchFreedomBoard(params: Params): FreedomBoardResponse

    suspend fun fetchFreedomBoardDetail(params: Params): FreedomBoardDetailResponse

    suspend fun fetchCommentList(params: Params): CommentResponse
}
