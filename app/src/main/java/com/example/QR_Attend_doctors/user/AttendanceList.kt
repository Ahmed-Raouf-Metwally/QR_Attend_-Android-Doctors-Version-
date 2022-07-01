package com.example.QR_Attend_doctors.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.api.ApiManager
import com.example.QR_Attend_doctors.api.AttendanceListRequest
import com.example.QR_Attend_doctors.model.AttendanceListResponse
import com.example.QR_Attend_doctors.model.AttendansItem
import com.example.QR_Attend_doctors.model.TopicsItem
import com.example.QR_Attend_doctors.ui.Adapters.StudentData
import com.example.QR_Attend_doctors.ui.Adapters.StudentsInAttendanceListAdapter
import com.example.QR_Attend_doctors.ui.dashboard.matID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AttendanceList : AppCompatActivity() {
    lateinit var studentsListRec : RecyclerView
    lateinit var studentsAdap : StudentsInAttendanceListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_list)
        studentsListRec = findViewById(R.id.students_attendance_rec)
        creatLsit()
        studentsAdap = StudentsInAttendanceListAdapter(studentList)
        studentsListRec.adapter = studentsAdap
    }
     var  studentList : MutableList<AttendansItem?>? = mutableListOf()
    fun creatLsit(){
     ApiManager.getApis().getAttendanceList(AttendanceListRequest(Mat_ID = matID.toString(), Topic_ID = topID )).enqueue(object :Callback<AttendanceListResponse>{
         override fun onResponse(
             call: Call<AttendanceListResponse>,
             response: Response<AttendanceListResponse>
         ) {
             Toast.makeText(applicationContext, "all is done", Toast.LENGTH_SHORT).show()
             studentsAdap.setData(response.body()?.attendans)
         }

         override fun onFailure(call: Call<AttendanceListResponse>, t: Throwable) {
             Toast.makeText(applicationContext, "network issue", Toast.LENGTH_SHORT).show()
         }

     })
    }
}