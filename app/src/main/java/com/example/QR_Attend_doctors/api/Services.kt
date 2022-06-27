package com.example.QR_Attend_doctors.api

import com.example.QR_Attend_doctors.model.LogInResponse
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.FormUrlEncoded

interface Services {


    @POST("logIn")
    fun LogIn(
        @Body doc : doctor
    ):Call<LogInResponse> ;
    @POST("logout")
    fun Logout(
        @Body doc: doctor
    ):Call<LogInResponse>
}