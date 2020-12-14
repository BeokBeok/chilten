package com.beok.chilten.domain.freedomboard.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FreedomBoardDetailDataItem(

	@Json(name="comment_count")
	val commentCount: String = "",

	@Json(name="is_chat_blocked")
	val isChatBlocked: String = "",

	@Json(name="isLike")
	val isLike: String = "",

	@Json(name="mod_date")
	val modDate: String = "",

	@Json(name="device_type")
	val deviceType: String? = null,

	@Json(name="likeCount")
	val likeCount: String = "",

	@Json(name="blind_date")
	val blindDate: String? = null,

	@Json(name="title")
	val title: String = "",

	@Json(name="member_idx")
	val memberIdx: String = "",

	@Json(name="content")
	val content: String = "",

	@Json(name="hit")
	val hit: String = "",

	@Json(name="token_id")
	val tokenId: String = "",

	@Json(name="center_idx")
	val centerIdx: String? = null,

	@Json(name="is_report")
	val isReport: String = "",

	@Json(name="user_agent")
	val userAgent: String = "",

	@Json(name="channelId")
	val channelId: String? = null,

	@Json(name="email")
	val email: String = "",

	@Json(name="has_file")
	val hasFile: String = "",

	@Json(name="channel_name")
	val channelName: String? = null,

	@Json(name="board_idx")
	val boardIdx: String = "",

	@Json(name="is_mobile")
	val isMobile: String = "",

	@Json(name="ip")
	val ip: String = "",

	@Json(name="member_name")
	val memberName: String = "",

	@Json(name="youtube_id")
	val youtubeId: String? = null,

	@Json(name="is_show")
	val isShow: String = "",

	@Json(name="picture")
	val picture: String = "",

	@Json(name="share_count")
	val shareCount: String = "",

	@Json(name="reg_date")
	val regDate: String = "",

	@Json(name="whodel")
	val whodel: String? = null,

	@Json(name="grade")
	val grade: String = "",

	@Json(name="nick_name")
	val nickName: String = "",

	@Json(name="post_idx")
	val postIdx: String = "",

	@Json(name="thumbnails")
	val thumbnails: String? = null,

	@Json(name="is_blind")
	val isBlind: String = "",

	@Json(name="is_notice")
	val isNotice: String = "",

	@Json(name="boardFile")
	val boardFile: List<BoardFileItem> = emptyList()
)
