package com.beok.chilten.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataItem(

	@Json(name="end_date")
	val endDate: String = "",

	@Json(name="st_date")
	val stDate: String = "",

	@Json(name="dis_cnt")
	val disCnt: String = "",

	@Json(name="kind")
	val kind: String = "",

	@Json(name="link")
	val link: String = "",

	@Json(name="clk_cnt")
	val clkCnt: String = "",

	@Json(name="mod_date")
	val modDate: String = "",

	@Json(name="bnseq")
	val bnseq: String = "",

	@Json(name="title")
	val title: String = "",

	@Json(name="linktarget")
	val linktarget: String = "",

	@Json(name="content")
	val content: String = "",

	@Json(name="is_show")
	val isShow: String = "",

	@Json(name="mode")
	val mode: String = "",

	@Json(name="reg_date")
	val regDate: String = "",

	@Json(name="background_color")
	val backgroundColor: String = "",

	@Json(name="image_path")
	val imagePath: String = "",

	@Json(name="is_del")
	val isDel: String = "",

	@Json(name="location")
	val location: String = "",

	@Json(name="image_path_m")
	val imagePathM: Any? = null,

	@Json(name="order")
	val order: String = ""
)