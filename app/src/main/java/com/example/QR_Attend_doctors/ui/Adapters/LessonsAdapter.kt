package com.example.QR_Attend_doctors.ui.Adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.QR_Attend_doctors.R

class LessonsAdapter(val LessonsNames: MutableList<String>) :
    RecyclerView.Adapter<LessonsAdapter.lessonViewHolder>() {
    class lessonViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val lessonName: TextView = item.findViewById(R.id.lesson_assignment_name)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): lessonViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.lesson_item, p0, false)
        return lessonViewHolder(view)
    }

    override fun onBindViewHolder(p0: lessonViewHolder, p1: Int) {
        val lessonName = LessonsNames[p1]
        p0.lessonName.setText(lessonName)
    }

    override fun getItemCount(): Int {
        return LessonsNames.size
    }
}