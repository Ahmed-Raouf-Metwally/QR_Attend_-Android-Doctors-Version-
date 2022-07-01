package com.example.QR_Attend_doctors.ui.dashboard
import androidx.lifecycle.ViewModelProvider
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.QR_Attend_doctors.MainActivity
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.api.ApiManager
import com.example.QR_Attend_doctors.api.Subjects
import com.example.QR_Attend_doctors.api.doctor
import com.example.QR_Attend_doctors.databinding.FragmentHomeBinding
import com.example.QR_Attend_doctors.model.LogInResponse
import com.example.QR_Attend_doctors.model.SubjectsItem
import com.example.QR_Attend_doctors.model.SubjectsResponse
import com.example.QR_Attend_doctors.ui.Adapters.SubjectsAdapter
import com.example.QR_Attend_doctors.ui.Adapters.SubjectsData
import com.example.QR_Attend_doctors.user.Lessons
import com.example.QR_Attend_doctors.user.doc
import com.google.android.material.floatingactionbutton.FloatingActionButton
import okhttp3.internal.notify
import okhttp3.internal.notifyAll
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
var SubjectsResponse: SubjectsResponse? = null
var matID : Int? = null
class DashboardFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(DashBoardViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View =
            binding.root
        return root
    }
lateinit var subsrecy : RecyclerView
lateinit var subsadap : SubjectsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subsrecy = view.findViewById(R.id.subjects_recycler)
        creat()
        subsadap = SubjectsAdapter(subNameList)
        subsrecy.adapter = subsadap
        subsadap.setSubjectClickListener(object : SubjectsAdapter.OnSubjectClickListener {
            override fun onSubjectClick(position: Int) {

                matID = SubjectsResponse?.subjects?.get(position)?.iD?:0
                var intent = Intent( requireContext(), Lessons::class.java)
                startActivity(intent)
            }

        })



    }
var subNameList : MutableList<SubjectsItem?>? = SubjectsResponse?.subjects ?: mutableListOf()


    fun creat(){
        ApiManager.getApis().GetSubjects(doc).enqueue(object : Callback<SubjectsResponse> {
            override fun onResponse(
                call: Call<SubjectsResponse>,
                response: Response<SubjectsResponse>
            ) {

                Toast.makeText(requireContext(), "DONE", Toast.LENGTH_SHORT).show()
                SubjectsResponse = response.body()
                subsadap.setData(response.body()?.subjects)
            }

            override fun onFailure(call: Call<SubjectsResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "network issue", Toast.LENGTH_SHORT).show()            }

        })

        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


