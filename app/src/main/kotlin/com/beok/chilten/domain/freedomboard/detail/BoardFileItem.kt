package com.beok.chilten.domain.freedomboard.detail

import com.squareup.moshi.Json

data class BoardFileItem(

	@Json(name="game_idx")
	val gameIdx: String = "",

	@Json(name="file_path")
	val filePath: String = "",

	@Json(name="thumbnail")
	val thumbnail: String = "",

	@Json(name="board_idx")
	val boardIdx: String = "",

	@Json(name="file_name")
	val fileName: String = "",

	@Json(name="org_file_name")
	val orgFileName: String = "",

	@Json(name="file_gubun")
	val fileGubun: String = "",

	@Json(name="center_auth_idx")
	val centerAuthIdx: String = "",

	@Json(name="file_size")
	val fileSize: String = "",

	@Json(name="is_show")
	val isShow: String = "",

	@Json(name="reg_date")
	val regDate: String = "",

	@Json(name="center_idx")
	val centerIdx: String = "",

	@Json(name="file_type")
	val fileType: String = "",

	@Json(name="file_idx")
	val fileIdx: String = "",

	@Json(name="is_del")
	val isDel: String = "",

	@Json(name="qa_idx")
	val qaIdx: String = "",

	@Json(name="post_idx")
	val postIdx: String = "",

	@Json(name="comment_idx")
	val commentIdx: String = ""
)
