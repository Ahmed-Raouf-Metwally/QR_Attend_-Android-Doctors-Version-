package com.example.QR_Attend_doctors.ui.splashscreen

import  androidx.appcompat.app.AppCompatActivity
import com.example.QR_Attend_doctors.R
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.QR_Attend_doctors.user.SignIn


class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splach_screen)
        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAGS_CHANGED,
            WindowManager.LayoutParams.FLAGS_CHANGED
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.
    }
}