package com.beok.chilten.domain

import com.beok.chilten.domain.banner.BannerRequest
import com.beok.chilten.domain.banner.BannerResponse
import com.beok.chilten.domain.comment.CommentResponse
import com.beok.chilten.domain.common.Params
import com.beok.chilten.domain.freedomboard.FreedomBoardResponse
import com.beok.chilten.domain.freedomboard.detail.FreedomBoardDetailResponse
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

    override suspend fun fetchFreedomBoardDetail(params: Params): FreedomBoardDetailResponse =
        withContext(ioDispatcher) {
            chiltenService.fetchFreedomBoardDetail(params)
        }

    override suspend fun fetchCommentList(params: Params): CommentResponse =
        withContext(ioDispatcher) {
            chiltenService.fetchCommentList(params)
        }
}
