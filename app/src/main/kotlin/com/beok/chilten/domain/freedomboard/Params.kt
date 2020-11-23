package com.beok.chilten.domain.freedomboard

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Params(

	@Json(name="board_idx")
	val boardIdx: Int = -1,

	@Json(name="page")
	val page: Int = -1
)
