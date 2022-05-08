package com.example.QR_Attend_doctors.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.databinding.FragmentSlideshowBinding
import com.example.QR_Attend_doctors.ui.Adapters.StudentData
import com.example.QR_Attend_doctors.ui.Adapters.StudentsInAttendanceListAdapter
import com.example.QR_Attend_doctors.ui.Adapters.SubjectsData

class MessageFragment : Fragment() {
    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(MessageViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }
lateinit var studentsListRec : RecyclerView
lateinit var studentsAdap : StudentsInAttendanceListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        studentsListRec = view.findViewById(R.id.students_attendance_rec)
        creatLsit()
        studentsAdap = StudentsInAttendanceListAdapter(studentList)
        studentsListRec.adapter = studentsAdap
    }
    lateinit var  studentList : MutableList<StudentData>
    fun creatLsit(){
        studentList = mutableListOf()
        studentList.add(StudentData(studentName = "Ahmed", studentId = "119000202", studentImage = R.drawable.profile_logo))
        studentList.add(StudentData(studentName = "mohamed", studentId = "119000203", studentImage = R.drawable.profile_logo))
        studentList.add(StudentData(studentName = "Ali", studentId = "119000204", studentImage = R.drawable.profile_logo))
        studentList.add(StudentData(studentName = "Mohsen", studentId = "119000205", studentImage = R.drawable.profile_logo))
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}