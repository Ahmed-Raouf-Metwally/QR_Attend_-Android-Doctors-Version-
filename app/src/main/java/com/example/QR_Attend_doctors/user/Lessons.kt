package com.example.QR_Attend_doctors.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.QR_Attend_doctors.MainActivity
import com.example.QR_Attend_doctors.QrScreen
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.api.ApiManager
import com.example.QR_Attend_doctors.api.AttendanceListRequest
import com.example.QR_Attend_doctors.api.Subjects
import com.example.QR_Attend_doctors.model.AttendanceListResponse
import com.example.QR_Attend_doctors.model.GenerateQRResponse
import com.example.QR_Attend_doctors.model.TopicsItem
import com.example.QR_Attend_doctors.model.TopicsResponse
import com.example.QR_Attend_doctors.ui.Adapters.LessonsAdapter
import com.example.QR_Attend_doctors.ui.dashboard.matID
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
var uRL: String? = null
var topID : String? = null
var topresponse:TopicsResponse?= null
class Lessons : AppCompatActivity() {
    lateinit var lessrec: RecyclerView
    lateinit var lessAdap: LessonsAdapter

    val topics: MutableList<TopicsItem?>? = mutableListOf()
    private fun creat() {
        ApiManager.getApis().GetAllTopics(Subjects(matID)).enqueue(object : Callback<TopicsResponse> {
            override fun onResponse(
                call: Call<TopicsResponse>,
                response: Response<TopicsResponse>
            ) {
                lessAdap.setData(response.body()?.topics)
                 topresponse= response.body()
            }

            override fun onFailure(call: Call<TopicsResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "network issue", Toast.LENGTH_SHORT).show()
            }

        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons)
        lessrec = findViewById(R.id.lessons_rec)
        creat()
        lessAdap = LessonsAdapter(topics)
        lessrec.adapter = lessAdap
        lessAdap.setTopicClickListener(object :LessonsAdapter.OnTopicClickListener{
            override fun onTopicClick(position: Int) {
                topID = topresponse?.topics?.get(position)?.iD
                val intent = Intent(applicationContext, AttendanceList::class.java)
                startActivity(intent)
            }

            override fun onButton(position: Int) {
                ApiManager.getApis().generateQr(AttendanceListRequest(Mat_ID = matID.toString(), Topic_ID =  topresponse?.topics?.get(position)?.iD)).enqueue(object :
                    Callback<GenerateQRResponse> {

                    override fun onResponse(
                        call: Call<GenerateQRResponse>,
                        response: Response<GenerateQRResponse>
                    ) {

                        uRL = response.body()?.uRL
                        Toast.makeText(applicationContext, "oh yeah", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, QrScreen::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }

                    override fun onFailure(call: Call<GenerateQRResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, "network issue", Toast.LENGTH_SHORT).show()
                    }

                })
            }
        })



    }
    }



