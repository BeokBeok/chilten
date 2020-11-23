package com.beok.chilten.domain.banner

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BannerResponse(

	@Json(name="data")
	val data: List<BannerDataItem> = listOf(),

	@Json(name="message")
	val message: String = "",

	@Json(name="status")
	val status: Int = -1
)

