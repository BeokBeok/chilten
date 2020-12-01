package com.beok.chilten.domain

import com.beok.chilten.domain.banner.BannerRequest
import com.beok.chilten.domain.banner.BannerResponse
import com.beok.chilten.domain.comment.CommentResponse
import com.beok.chilten.domain.common.Params
import com.beok.chilten.domain.freedomboard.FreedomBoardResponse
import com.beok.chilten.domain.freedomboard.detail.FreedomBoardDetailResponse
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

    suspend fun fetchFreedomBoardDetail(params: Params): FreedomBoardDetailResponse =
        withContext(ioDispatcher) {
            remoteDataSource.fetchFreedomBoardDetail(params)
        }

    suspend fun fetchCommentList(params: Params): CommentResponse =
        withContext(ioDispatcher) {
            remoteDataSource.fetchCommentList(params)
        }
}
