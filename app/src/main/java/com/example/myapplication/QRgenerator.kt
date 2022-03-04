package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class QRgenerator : AppCompatActivity() {
   lateinit var qrImage : ImageView
   lateinit var generateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrgenerator)
        qrImage = findViewById(R.id.Qr_Viewer)
        generateButton = findViewById(R.id.Generate_QR_Button)
        generateButton.setOnClickListener {
          qrImage.setImageResource(R.drawable.qr_test)
        }
    }
}