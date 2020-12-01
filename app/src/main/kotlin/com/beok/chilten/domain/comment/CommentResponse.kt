package com.beok.chilten.domain.comment

import com.beok.chilten.domain.common.Params
import com.squareup.moshi.Json

data class CommentResponse(

	@Json(name="data")
	val data: List<CommentDataItem> = emptyList(),

	@Json(name="boardGrade")
	val boardGrade: List<String> = emptyList(),

	@Json(name="length")
	val length: Int = -1,

	@Json(name="message")
	val message: String = "",

	@Json(name="params")
	val params: Params = Params(),

	@Json(name="status")
	val status: Int = -1,

	@Json(name="aResultBoardConfig")
	val aResultBoardConfig: AResultBoardConfig = AResultBoardConfig()
)
