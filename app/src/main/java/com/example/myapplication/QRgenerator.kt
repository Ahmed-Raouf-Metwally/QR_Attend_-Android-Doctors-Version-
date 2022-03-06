package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible

class QRgenerator : AppCompatActivity() {
   lateinit var qrImage : ImageView
   lateinit var generateButton: Button
   lateinit var creatSessionButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrgenerator)
        qrImage = findViewById(R.id.Qr_Viewer)
        creatSessionButton = findViewById(R.id.create_session_button)
        generateButton = findViewById(R.id.Generate_QR_Button)
        generateButton.setOnClickListener {
          qrImage.setImageResource(R.drawable.qr_test)
        }
        creatSessionButton.setOnClickListener {
           generateButton.setVisibility(View.VISIBLE)
    }
}
}