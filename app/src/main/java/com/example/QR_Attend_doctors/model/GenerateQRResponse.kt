package com.example.QR_Attend_doctors.model

import com.google.gson.annotations.SerializedName

data class GenerateQRResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("URL")
	val uRL: String? = null
)
