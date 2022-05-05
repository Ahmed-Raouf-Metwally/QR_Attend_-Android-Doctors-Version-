package com.example.QR_Attend_doctors.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.QR_Attend_doctors.R

class ProfileActivity : AppCompatActivity() {
    lateinit var signOutButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        signOutButton = findViewById(R.id.sign_out_button)
        signOutButton.setOnClickListener {
            val intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }
    }
}