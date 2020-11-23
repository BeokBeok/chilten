package com.beok.chilten.domain.freedomboard

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ABoardConfig(

	@Json(name="board_idx")
	val boardIdx: String = "",

	@Json(name="able_write")
	val ableWrite: String = "",

	@Json(name="board_type")
	val boardType: String = "",

	@Json(name="is_use_realname")
	val isUseRealname: String = "",

	@Json(name="description")
	val description: String = "",

	@Json(name="is_use_board")
	val isUseBoard: String = "",

	@Json(name="sort")
	val sort: String = "",

	@Json(name="admin_email")
	val adminEmail: String = "",

	@Json(name="board_name")
	val boardName: String = "",

	@Json(name="able_read")
	val ableRead: String = "",

	@Json(name="reg_date")
	val regDate: String = "",

	@Json(name="board_sub_type")
	val boardSubType: String = "",

	@Json(name="center_idx")
	val centerIdx: String = "",

	@Json(name="able_comment")
	val ableComment: String = "",

	@Json(name="is_comment")
	val isComment: String = "",

	@Json(name="club_idx")
	val clubIdx: String = "",

	@Json(name="is_use_nickname")
	val isUseNickname: String = ""
)
