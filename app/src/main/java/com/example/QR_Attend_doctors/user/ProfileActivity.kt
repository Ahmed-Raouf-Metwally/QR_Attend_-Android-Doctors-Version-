package com.example.QR_Attend_doctors.user

import android.app.admin.FreezePeriod
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.api.ApiManager
import com.example.QR_Attend_doctors.model.LogInResponse
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {
    lateinit var signOutButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        signOutButton = findViewById(R.id.sign_out_button)
        signOutButton.setOnClickListener {
            ApiManager.getApis().Logout(doc).enqueue(object :Callback<LogInResponse>{


                override fun onResponse(
                    call: Call<LogInResponse>,
                    response: Response<LogInResponse>
                ) {

                    val intent = Intent(applicationContext,SignIn::class.java)
                    startActivity(intent)
                }

                override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "sorry try again later", Toast.LENGTH_SHORT).show()
                }
            })

        }
    }

}