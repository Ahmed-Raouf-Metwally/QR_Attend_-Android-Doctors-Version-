package com.example.QR_Attend_doctors.user

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.QR_Attend_doctors.MainActivity
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.api.ApiManager
import com.example.QR_Attend_doctors.api.doctor

import com.example.QR_Attend_doctors.model.LogInResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
lateinit var doc : doctor
var responseLogInResponse:LogInResponse?=null
class SignIn : AppCompatActivity() {
    lateinit var log_in: Button
    lateinit var Email : EditText
    lateinit var Password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        Email = findViewById(R.id.email)
        Password = findViewById(R.id.password)
        log_in = findViewById(R.id.log_in)


        log_in.setOnClickListener {
            val email:String? = Email.text.toString().trim()
            val password:String? = Password.text.toString().trim()

            if(email!!.isEmpty()){
                Email.error = "Email required"
                Email.requestFocus()
                return@setOnClickListener
            }


            if(password!!.isEmpty()){
                Password.error = "Password required"
                Password.requestFocus()
                return@setOnClickListener
            }

            doc = doctor(email,password)
           ApiManager.getApis().LogIn(doc).enqueue(object :Callback<LogInResponse>{
               override fun onResponse(
                   call: Call<LogInResponse>,
                   response: Response<LogInResponse>
               ) {
                   if(response.body()?.id != null){
                       doc = doctor(response.body()?.iD)
                       responseLogInResponse = response.body()
                       val intent = Intent(this@SignIn, MainActivity::class.java)
                       intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                       startActivity(intent)
                   }
                   else{
                       Toast.makeText(applicationContext, "check your email or password", Toast.LENGTH_SHORT).show()
                   }
               }

               override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                   Log.e("response",  t.message.toString(), )
               }

           })
        }

    }

}
