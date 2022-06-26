package com.example.QR_Attend_doctors.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Level


class ApiManager {
companion object{
    private val Basr_URL = "https://qr-atendans.herokuapp.com/";
    private var retrofit:Retrofit?= null
    private fun getInstance():Retrofit{
        if(retrofit == null){
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
         retrofit = Retrofit.Builder().baseUrl(Basr_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit!!;
    }
    fun getApis():Services{
        return getInstance().create(Services::class.java)
    }
}
}