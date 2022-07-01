package com.example.QR_Attend_doctors.model

import com.google.gson.annotations.SerializedName

data class AttendanceListResponse(

	@field:SerializedName("Attendans")
	val attendans: MutableList<AttendansItem?>? = null
)

data class AttendansItem(

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("Name")
	val name: String? = null
)
