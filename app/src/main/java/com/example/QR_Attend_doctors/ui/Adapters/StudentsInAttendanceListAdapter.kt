package com.example.QR_Attend_doctors.ui.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.QR_Attend_doctors.R

class StudentsInAttendanceListAdapter(val students : MutableList<StudentData>):RecyclerView.Adapter<StudentsInAttendanceListAdapter.StudentsviewHolder>() {
    class StudentsviewHolder(Itemview : View): RecyclerView.ViewHolder(Itemview){
        val studentImage :ImageView = Itemview.findViewById(R.id.student_image_in_attendance_list)
        val studentName : TextView = Itemview.findViewById(R.id.student_name_in_attendance_list)
        val  studentId : TextView = Itemview.findViewById(R.id.student_id)
        val firebtn : Button = itemView.findViewById(R.id.fire_student)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.attende_view_card,parent,false)
        return StudentsviewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentsviewHolder, position: Int) {
        val stu = students[position]
        holder.studentName.setText(stu.studentName)
        holder.studentId.setText(stu.studentId)
        holder.studentImage.setImageResource(stu.studentImage)
    }

    override fun getItemCount(): Int {
        return students.size
    }
}