package com.beok.chilten.freedomboard

import com.beok.chilten.domain.freedomboard.FreedomBoardResponse

data class FreedomBoardGroup(
    val length: Int = 0,
    val page: Int = 0,
    val data: List<FreedomBoardItem> = emptyList()
) {

    operator fun plus(freedomBoardGroup: FreedomBoardGroup): FreedomBoardGroup =
        FreedomBoardGroup(
            length = this.length + freedomBoardGroup.length,
            page = freedomBoardGroup.page,
            data = this.data.plus(freedomBoardGroup.data)
        )

    companion object {
        fun toGroup(freedomBoardResponse: FreedomBoardResponse) =
            FreedomBoardGroup(
                length = freedomBoardResponse.length,
                page = freedomBoardResponse.params.page,
                data = freedomBoardResponse.data.map(FreedomBoardItem::toItem)
            )
    }
}
