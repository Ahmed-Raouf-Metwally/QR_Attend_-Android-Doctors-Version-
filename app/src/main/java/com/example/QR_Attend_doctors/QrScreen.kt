package com.example.QR_Attend_doctors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.QR_Attend_doctors.user.uRL
import com.google.android.material.floatingactionbutton.FloatingActionButton


class QrScreen : AppCompatActivity() {
    lateinit var generatedQr : ImageView
    lateinit var home :FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_qr_screen)
        generatedQr = findViewById(R.id.generated_QR_image)

        runOnUiThread {
            Glide.with(applicationContext).load(uRL).into(generatedQr)
        }
          generatedQr.setOnClickListener {
              val intent = Intent(applicationContext, MainActivity::class.java)
              intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
              startActivity(intent)
          }

    }
}