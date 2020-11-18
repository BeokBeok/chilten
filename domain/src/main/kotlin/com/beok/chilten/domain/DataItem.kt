package com.beok.chilten.domain

import com.squareup.moshi.Json

data class DataItem(

	@Json(name="end_date")
	val endDate: String? = null,

	@Json(name="st_date")
	val stDate: String? = null,

	@Json(name="dis_cnt")
	val disCnt: String? = null,

	@Json(name="kind")
	val kind: String? = null,

	@Json(name="link")
	val link: String? = null,

	@Json(name="clk_cnt")
	val clkCnt: String? = null,

	@Json(name="mod_date")
	val modDate: String? = null,

	@Json(name="bnseq")
	val bnseq: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="linktarget")
	val linktarget: String? = null,

	@Json(name="content")
	val content: String? = null,

	@Json(name="is_show")
	val isShow: String? = null,

	@Json(name="mode")
	val mode: String? = null,

	@Json(name="reg_date")
	val regDate: String? = null,

	@Json(name="background_color")
	val backgroundColor: String? = null,

	@Json(name="image_path")
	val imagePath: String? = null,

	@Json(name="is_del")
	val isDel: String? = null,

	@Json(name="location")
	val location: String? = null,

	@Json(name="image_path_m")
	val imagePathM: Any? = null,

	@Json(name="order")
	val order: String? = null
)