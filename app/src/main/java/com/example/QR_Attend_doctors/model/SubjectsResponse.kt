package com.example.QR_Attend_doctors.model

import com.google.gson.annotations.SerializedName

data class SubjectsResponse(

	@field:SerializedName("Supjects")
	val subjects: MutableList<SubjectsItem?>? = null
)

data class SubjectsItem(

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("Code")
	val code: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
)
