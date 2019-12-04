package com.udacoding.kulinerdanwisata.model

import com.google.gson.annotations.SerializedName

data class ResultWisata(

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)