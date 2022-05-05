package com.example.QR_Attend_doctors.ui.Adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.QR_Attend_doctors.R

class SubjectsAdapter(val subjects: MutableList<SubjectsData>):
    RecyclerView.Adapter<SubjectsAdapter.SubjectViewHolder>() {
    class SubjectViewHolder(ItemView: View, subLitener: OnSubjectClickListener) :
        RecyclerView.ViewHolder(ItemView) {
        val backgroundImage: ImageView =
            ItemView.findViewById(com.example.QR_Attend_doctors.R.id.background_views)
        val subjectName: TextView = ItemView.findViewById(R.id.subject_name)
        val progressInSub: TextView =
            ItemView.findViewById(com.example.QR_Attend_doctors.R.id.progressBar)

        init {
            ItemView.setOnClickListener {
                subLitener.onSubjectClick(adapterPosition)
            }
        }
    }

    private lateinit var subjcetListener: OnSubjectClickListener
    public fun setSubjectClickListener(subLitener: OnSubjectClickListener) {
        subjcetListener = subLitener
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SubjectViewHolder {
        val View = LayoutInflater.from(p0.context).inflate(R.layout.subjects_layout, p0, false)
        return SubjectViewHolder(View, subjcetListener);
    }

    override fun onBindViewHolder(p0: SubjectViewHolder, p1: Int) {
        val subs = subjects[p1]
        p0.subjectName.setText(subs.subjectName)
        p0.backgroundImage.setImageResource(subs.backGroundImageDAsh)
        p0.progressInSub.setText(subs.progress)
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    interface OnSubjectClickListener {
        fun onSubjectClick(position: Int)
    }
}