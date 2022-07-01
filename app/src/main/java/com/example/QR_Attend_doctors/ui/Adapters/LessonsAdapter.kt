package com.example.QR_Attend_doctors.ui.Adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.model.TopicsItem
import okhttp3.internal.notifyAll

class LessonsAdapter(var LessonsNames: MutableList<TopicsItem?>?) :
    RecyclerView.Adapter<LessonsAdapter.lessonViewHolder>() {
    class lessonViewHolder(item: View , topicListener:OnTopicClickListener ) : RecyclerView.ViewHolder(item) {
        val lessonName: TextView = item.findViewById(R.id.lesson_assignment_name)
        val lessonDesc : TextView = item.findViewById(R.id.descriptio_lesson)
        init {
            item.setOnClickListener {
                topicListener.onTopicClick(adapterPosition)
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
    }
}