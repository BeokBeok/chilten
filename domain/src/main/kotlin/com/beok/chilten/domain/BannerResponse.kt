package com.beok.chilten.domain

import com.squareup.moshi.Json

data class BannerResponse(

	@Json(name="data")
	val data: List<DataItem?>? = null,

	@Json(name="message")
	val message: String? = null,

	@Json(name="status")
	val status: Int? = null
)

