package com.beok.chilten.domain.comment

import com.squareup.moshi.Json

data class AResultBoardConfig(

	@Json(name="board_idx")
	val boardIdx: String? = null,

	@Json(name="able_write")
	val ableWrite: String? = null,

	@Json(name="board_type")
	val boardType: String? = null,

	@Json(name="is_use_realname")
	val isUseRealname: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="is_use_board")
	val isUseBoard: String? = null,

	@Json(name="sort")
	val sort: String? = null,

	@Json(name="admin_email")
	val adminEmail: String? = null,

	@Json(name="board_name")
	val boardName: String? = null,

	@Json(name="able_read")
	val ableRead: String? = null,

	@Json(name="reg_date")
	val regDate: String? = null,

	@Json(name="board_sub_type")
	val boardSubType: String? = null,

	@Json(name="center_idx")
	val centerIdx: String? = null,

	@Json(name="able_comment")
	val ableComment: String? = null,

	@Json(name="is_comment")
	val isComment: String? = null,

	@Json(name="club_idx")
	val clubIdx: String? = null,

	@Json(name="is_use_nickname")
	val isUseNickname: String? = null
)
