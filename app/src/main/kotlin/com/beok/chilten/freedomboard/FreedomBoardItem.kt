package com.beok.chilten.freedomboard

import com.beok.chilten.domain.freedomboard.FreedomBoardDataItem
import com.beok.chilten.util.Constants

data class FreedomBoardItem(
    val boardIdx: Int,
    val postIdx: Int,
    val imageUrl: String,
    val isNotice: Boolean,
    val title: String,
    val nickName: String,
    val registerDate: String,
    val hit: Int
) {

    companion object {
        fun toItem(freedomBoardDataItem: FreedomBoardDataItem) = FreedomBoardItem(
            boardIdx = freedomBoardDataItem.boardIdx.toInt(),
            postIdx = freedomBoardDataItem.postIdx.toInt(),
            imageUrl = if (freedomBoardDataItem.filePath.isNullOrEmpty()) "" else "${Constants.PREFIX_IMAGE_URL}${freedomBoardDataItem.filePath}",
            isNotice = freedomBoardDataItem.isNotice == "T",
            title = freedomBoardDataItem.title,
            nickName = freedomBoardDataItem.nickName,
            registerDate = freedomBoardDataItem.regDate,
            hit = freedomBoardDataItem.hit.toInt()
        )
    }
}
