package com.beok.chilten.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BannerResponse(

	@Json(name="data")
	val data: List<DataItem> = listOf(),

	@Json(name="message")
	val message: String = "",

	@Json(name="status")
	val status: Int = -1
)

