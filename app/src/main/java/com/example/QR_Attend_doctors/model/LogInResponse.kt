package com.example.QR_Attend_doctors.model

import com.google.gson.annotations.SerializedName

data class  LogInResponse(

	@field:SerializedName("Role")
	val role: Int? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("Email")
	val email: String? = null,

	@field:SerializedName("LogedIn")
	val logedIn: Boolean? = null,

	@field:SerializedName("matrials")
	val matrials: List<Any?>? = null,

	@field:SerializedName("__v")
	val V: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("Subjects")
	val subjects: List<Any?>? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("Password")
	val password: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
