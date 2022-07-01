package com.example.QR_Attend_doctors.ui.Adapters

import android.app.AlertDialog
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import com.bumptech.glide.Glide
import com.example.QR_Attend_doctors.MainActivity
import com.example.QR_Attend_doctors.QrScreen
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.api.ApiManager
import com.example.QR_Attend_doctors.api.AttendanceListRequest
import com.example.QR_Attend_doctors.model.GenerateQRResponse
import com.example.QR_Attend_doctors.model.TopicsItem
import com.example.QR_Attend_doctors.ui.dashboard.matID
import com.example.QR_Attend_doctors.user.topresponse
import okhttp3.internal.notifyAll
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LessonsAdapter(var LessonsNames: MutableList<TopicsItem?>?) :
    RecyclerView.Adapter<LessonsAdapter.lessonViewHolder>() {
    class lessonViewHolder(item: View , topicListener:OnTopicClickListener ) : RecyclerView.ViewHolder(item) {
        val lessonName: TextView = item.findViewById(R.id.lesson_assignment_name)
        val lessonDesc : TextView = item.findViewById(R.id.descriptio_lesson)
        val generateqr : Button = item.findViewById(R.id.show_qr_code)
        init {
            item.setOnClickListener {
                topicListener.onTopicClick(adapterPosition)
            }
        }
        init {
            generateqr.setOnClickListener {
               topicListener.onButton(adapterPosition)


            }
        }


    }
    private lateinit var topictListener: LessonsAdapter.OnTopicClickListener
    public fun setTopicClickListener(topLitener: LessonsAdapter.OnTopicClickListener) {
        topictListener = topLitener

    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): lessonViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.lesson_item, p0, false)
        return lessonViewHolder(view,topictListener)
    }

    override fun onBindViewHolder(p0: lessonViewHolder, p1: Int) {
        val lessonName = LessonsNames?.get(p1)
        p0.lessonName?.setText(lessonName?.name)
        p0.lessonDesc?.setText(lessonName?.discption)



    }

    override fun getItemCount(): Int {
        return LessonsNames?.size?:0
    }
fun setData(data: MutableList<TopicsItem?>?){
    LessonsNames = data
    notifyDataSetChanged()
}
    interface OnTopicClickListener {
        fun onTopicClick(position: Int)
        fun onButton(position: Int)
    }
}