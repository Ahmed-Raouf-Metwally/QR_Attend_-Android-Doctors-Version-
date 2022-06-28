package com.example.QR_Attend_doctors.user

import android.app.admin.FreezePeriod
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.QR_Attend_doctors.MainActivity
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.api.ApiManager
import com.example.QR_Attend_doctors.model.LogInResponse
import com.google.android.material.floatingactionbutton.FloatingActionButton
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {
    lateinit var signOutButton: Button
    lateinit var DoctorNam :TextView
    lateinit var DocorEmail : TextView
    lateinit var backHome : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        DoctorNam = findViewById(R.id.name_profile_view)
        DocorEmail = findViewById(R.id.email_prof_view)
        signOutButton = findViewById(R.id.sign_out_button)
        backHome = findViewById(R.id.back_home)
        DoctorNam.setText(responseLogInResponse?.name)
        DocorEmail.setText(responseLogInResponse?.email)
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
        backHome.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }

}