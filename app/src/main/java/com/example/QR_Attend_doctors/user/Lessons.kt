package com.example.QR_Attend_doctors.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.api.ApiManager
import com.example.QR_Attend_doctors.api.Subjects
import com.example.QR_Attend_doctors.model.TopicsItem
import com.example.QR_Attend_doctors.model.TopicsResponse
import com.example.QR_Attend_doctors.ui.Adapters.LessonsAdapter
import com.example.QR_Attend_doctors.ui.dashboard.matID
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Lessons : AppCompatActivity() {
    lateinit var lessrec: RecyclerView
    lateinit var lessAdap: LessonsAdapter
    lateinit var addbtn : FloatingActionButton
    val topics: MutableList<TopicsItem?>? = mutableListOf()
    private fun creat() {
        ApiManager.getApis().GetAllTopics(Subjects(matID)).enqueue(object : Callback<TopicsResponse> {
            override fun onResponse(
                call: Call<TopicsResponse>,
                response: Response<TopicsResponse>
            ) {
                lessAdap.setData(response.body()?.topics)

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
        addbtn = findViewById(R.id.add_new_lesson_button)
    addbtn.setOnClickListener {
        val view =View.inflate(this,R.layout.add_new_lesson,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
        val confirm:FloatingActionButton = view.findViewById(R.id.confirm)
        val cancel:FloatingActionButton = view.findViewById(R.id.cancel_add_lesson_button)
        val title : EditText = view.findViewById(R.id.topic_name)
        confirm.setOnClickListener {
        if (title.text != null){
            val input : String = title.text.toString()

            dialog.dismiss()
        }

        }
        cancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setCancelable(false)
    }

        val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.layoutPosition
                 topics?.removeAt(position)
                 lessrec.adapter?.notifyItemRemoved(position)
            }


        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(lessrec)
    }
    }



