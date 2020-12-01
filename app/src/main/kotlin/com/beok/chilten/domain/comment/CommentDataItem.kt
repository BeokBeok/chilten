package com.beok.chilten.domain.comment

import com.squareup.moshi.Json

data class CommentDataItem(

	@Json(name="image")
	val image: String? = null,

	@Json(name="board_idx")
	val boardIdx: String = "",

	@Json(name="parent_nick_name")
	val parentNickName: String = "",

	@Json(name="is_chat_blocked")
	val isChatBlocked: String = "",

	@Json(name="parent_idx")
	val parentIdx: String = "",

	@Json(name="del_memo")
	val delMemo: String? = null,

	@Json(name="member_idx")
	val memberIdx: String = "",

	@Json(name="member_name")
	val memberName: String = "",

	@Json(name="content")
	val content: String = "",

	@Json(name="picture")
	val picture: String = "",

	@Json(name="reg_date")
	val regDate: String = "",

	@Json(name="replyCount")
	val replyCount: String = "",

	@Json(name="whodel")
	val whodel: String? = null,

	@Json(name="comment_type")
	val commentType: String = "",

	@Json(name="file_idx")
	val fileIdx: String? = null,

	@Json(name="nick_name")
	val nickName: String = "",

	@Json(name="grade")
	val grade: String = "",

	@Json(name="is_del")
	val isDel: String = "",

	@Json(name="post_idx")
	val postIdx: String = "",

	@Json(name="comment_idx")
	val commentIdx: String = "",

	@Json(name="email")
	val email: String = ""
)
