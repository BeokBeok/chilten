package com.beok.chilten.domain.freedomboard

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FreedomBoardDataItem(

	@Json(name="comment_count")
	val commentCount: String = "",

	@Json(name="file_path")
	val filePath: String? = null,

	@Json(name="board_idx")
	val boardIdx: String = "",

	@Json(name="board_type")
	val boardType: String = "",

	@Json(name="blind_date")
	val blindDate: Any? = null,

	@Json(name="member_name")
	val memberName: String = "",

	@Json(name="title")
	val title: String = "",

	@Json(name="content")
	val content: String = "",

	@Json(name="board_name")
	val boardName: String = "",

	@Json(name="share_count")
	val shareCount: String = "",

	@Json(name="reg_date")
	val regDate: String = "",

	@Json(name="board_sub_type")
	val boardSubType: String = "",

	@Json(name="hit")
	val hit: String = "",

	@Json(name="whodel")
	val whodel: Any? = null,

	@Json(name="grade")
	val grade: String = "",

	@Json(name="nick_name")
	val nickName: String = "",

	@Json(name="post_idx")
	val postIdx: String = "",

	@Json(name="is_blind")
	val isBlind: String = "",

	@Json(name="email")
	val email: String = "",

	@Json(name="is_notice")
	val isNotice: String = ""
)
