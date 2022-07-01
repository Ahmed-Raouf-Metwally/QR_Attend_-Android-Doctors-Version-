package com.example.QR_Attend_doctors.ui.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.model.AttendansItem
import com.google.android.material.floatingactionbutton.FloatingActionButton
import okhttp3.internal.notifyAll

class StudentsInAttendanceListAdapter(var students : MutableList<AttendansItem?>?):RecyclerView.Adapter<StudentsInAttendanceListAdapter.StudentsviewHolder>() {
    class StudentsviewHolder(Itemview : View): RecyclerView.ViewHolder(Itemview){
        val studentImage :ImageView = Itemview.findViewById(R.id.student_image_in_attendance_list)
        val studentName : TextView = Itemview.findViewById(R.id.student_name_in_attendance_list)
        val  studentId : TextView = Itemview.findViewById(R.id.student_id)
        val firebtn : FloatingActionButton = itemView.findViewById(R.id.fire_student)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.attende_view_card,parent,false)
        return StudentsviewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentsviewHolder, position: Int) {
        val stu = students?.get(position)
        holder.studentName.setText(stu?.name)
        holder.studentId.setText(stu?.iD.toString())
        holder.studentImage.setImageResource(R.drawable.profile_logo)
    }

    override fun getItemCount(): Int {
        return students?.size?:0
    }
    fun setData( students : MutableList<AttendansItem?>?){
        this.students = students
        notifyDataSetChanged()

    }

}