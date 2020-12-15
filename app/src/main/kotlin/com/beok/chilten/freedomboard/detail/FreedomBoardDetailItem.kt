package com.beok.chilten.freedomboard.detail

import com.beok.chilten.domain.freedomboard.detail.FreedomBoardDetailResponse

data class FreedomBoardDetailItem(
    val title: String,
    val picture: String,
    val nickName: String,
    val regDate: String,
    val hit: String,
    val content: String,
    val filePathList: List<String>
) {

    companion object {

        fun toItem(freedomBoardDetailResponse: FreedomBoardDetailResponse) = FreedomBoardDetailItem(
            title = freedomBoardDetailResponse.data.title,
            picture = freedomBoardDetailResponse.data.picture,
            nickName = freedomBoardDetailResponse.data.nickName,
            regDate = freedomBoardDetailResponse.data.regDate,
            hit = freedomBoardDetailResponse.data.hit,
            content = freedomBoardDetailResponse.data.content,
            filePathList = freedomBoardDetailResponse.data.boardFile.map { it.filePath }
        )
    }
}
