package com.example.QR_Attend_doctors.api

import com.example.QR_Attend_doctors.model.AddTopicResponse
import com.example.QR_Attend_doctors.model.LogInResponse
import com.example.QR_Attend_doctors.model.SubjectsResponse
import com.example.QR_Attend_doctors.model.TopicsResponse
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.FormUrlEncoded

interface Services {


    @POST("logIn")
    fun LogIn( @Body doc : doctor):Call<LogInResponse> ;
    @POST("logout")
    fun Logout(@Body doc: doctor):Call<LogInResponse>;
    @POST("getDrAlltopic")
    fun GetAllTopics(@Body subjects: Subjects):Call<TopicsResponse>;
    @POST("getDrmat")
    fun GetSubjects(@Body doc: doctor):Call<SubjectsResponse>;
    @POST ("addtopic")
    fun AddTopic( @Body AddTopicData:AddTopicData ): Call<AddTopicResponse>

}