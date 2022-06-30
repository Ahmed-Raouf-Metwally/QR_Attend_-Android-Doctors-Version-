package com.example.QR_Attend_doctors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.QR_Attend_doctors.api.AddTopicData
import com.example.QR_Attend_doctors.api.ApiManager
import com.example.QR_Attend_doctors.model.AddTopicResponse
import com.example.QR_Attend_doctors.model.SubjectsResponse
import com.example.QR_Attend_doctors.ui.scan.mat_Id
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QRgenerator : AppCompatActivity() {
   lateinit var qrImage : ImageView
   lateinit var generateButton: Button
   lateinit var creatSessionButton: Button
   lateinit var SessionName: EditText
   lateinit var SessionDesc: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrgenerator)
        qrImage = findViewById(R.id.Qr_Viewer)
        creatSessionButton = findViewById(R.id.create_session_button)
        generateButton = findViewById(R.id.Generate_QR_Button)
        SessionName = findViewById(R.id.session_name_view)
        SessionDesc = findViewById(R.id.description_for_session_view)
        generateButton.setOnClickListener {
          qrImage.setImageResource(R.drawable.qr_test)
        }

        creatSessionButton.setOnClickListener {
            var Name: String? = SessionName.text.toString().trim()
            var descrip: String? = SessionDesc.text.toString().trim()
            if(Name!!.isEmpty()){
                SessionName.error = "topic name is required"
                SessionName.requestFocus()
                return@setOnClickListener
            }


            if(descrip!!.isEmpty()){
                SessionDesc.error = "Plesae enter topic description"
                SessionDesc.requestFocus()
                return@setOnClickListener
            }
            var NewTopic:AddTopicData = AddTopicData(Name=Name, Mat_ID = mat_Id,Discption=descrip)
             ApiManager.getApis().AddTopic(NewTopic).enqueue(object : Callback<AddTopicResponse>{
                 override fun onResponse(
                     call: Call<AddTopicResponse>,
                     response: Response<AddTopicResponse>
                 ) {
                     Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_SHORT).show()
                 }

                 override fun onFailure(call: Call<AddTopicResponse>, t: Throwable) {
                     TODO("Not yet implemented")
                 }


             })
            generateButton.setVisibility(View.VISIBLE)
    }
}
}