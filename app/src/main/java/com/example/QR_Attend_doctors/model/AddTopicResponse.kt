package com.example.QR_Attend_doctors.model

import com.google.gson.annotations.SerializedName

data class AddTopicResponse(

	@field:SerializedName("matrial")
	val matrial: Matrial? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("savedtopic")
	val savedtopic: Savedtopic? = null
)

data class Matrial(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("topics")
	val topics: List<String?>? = null,

	@field:SerializedName("__v")
	val V: Int? = null,

	@field:SerializedName("Level")
	val level: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("Code")
	val code: String? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

data class Savedtopic(

	@field:SerializedName("QR")
	val qR: String? = null,

	@field:SerializedName("Mat_ref")
	val matRef: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("__v")
	val V: Int? = null,

	@field:SerializedName("Discption")
	val discption: String? = null,

	@field:SerializedName("ID")
	val iD: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
