package com.beok.chilten.domain.freedomboard.detail

import com.beok.chilten.domain.freedomboard.ABoardConfig
import com.beok.chilten.domain.freedomboard.Params
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FreedomBoardDetailResponse(

	@Json(name="aBoardConfig")
	val aBoardConfig: ABoardConfig = ABoardConfig(),

	@Json(name="data")
	val data: FreedomBoardDetailDataItem = FreedomBoardDetailDataItem(),

	@Json(name="able_comment")
	val ableComment: String = "",

	@Json(name="message")
	val message: String = "",

	@Json(name="params")
	val params: Params = Params(),

	@Json(name="status")
	val status: Int = -1
)
