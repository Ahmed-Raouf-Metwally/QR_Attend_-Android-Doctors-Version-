package com.example.QR_Attend_doctors.model

import com.google.gson.annotations.SerializedName

data class TopicsResponse(

	@field:SerializedName("Topics")
	val topics: MutableList<TopicsItem?>? = null
)

data class TopicsItem(

	@field:SerializedName("Mat_ref")
	val matRef: String? = null,

	@field:SerializedName("Discption")
	val discption: String? = null,

	@field:SerializedName("ID")
	val iD: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
)
