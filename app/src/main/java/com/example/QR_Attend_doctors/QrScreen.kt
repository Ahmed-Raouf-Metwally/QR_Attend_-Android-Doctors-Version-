package com.example.QR_Attend_doctors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.QR_Attend_doctors.user.uRL


class QrScreen : AppCompatActivity() {
    lateinit var generatedQr : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_screen)
        generatedQr = findViewById(R.id.generated_QR_image)
        Glide.with(applicationContext).load(uRL).into(generatedQr)

    }
}