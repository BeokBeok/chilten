package com.beok.chilten.domain.freedomboard

import com.beok.chilten.domain.common.Params
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FreedomBoardResponse(

	@Json(name="aBoardConfig")
	val aBoardConfig: ABoardConfig = ABoardConfig(),

	@Json(name="data")
	val data: List<FreedomBoardDataItem> = emptyList(),

	@Json(name="length")
	val length: Int = -1,

	@Json(name="message")
	val message: String = "",

	@Json(name="params")
	val params: Params = Params(),

	@Json(name="status")
	val status: Int = -1
)
