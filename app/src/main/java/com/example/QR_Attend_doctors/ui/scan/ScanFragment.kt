package com.example.QR_Attend_doctors.ui.scan

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.QR_Attend_doctors.QRgenerator
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.api.ApiManager
import com.example.QR_Attend_doctors.databinding.FragmentGalleryBinding
import com.example.QR_Attend_doctors.model.SubjectsItem
import com.example.QR_Attend_doctors.model.SubjectsResponse
import com.example.QR_Attend_doctors.ui.Adapters.SubjectsAdapter
import com.example.QR_Attend_doctors.ui.Adapters.SubjectsData
import com.example.QR_Attend_doctors.ui.dashboard.SubjectsResponse
import com.example.QR_Attend_doctors.user.doc
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScanFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(ScanViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }
    lateinit var subsrecy : RecyclerView
    lateinit var subsadap : SubjectsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subsrecy = view.findViewById(R.id.Grid_recycler)
        creat()
        subsadap = SubjectsAdapter(subNameList)
        subsrecy.adapter = subsadap
        val gridLayout:GridLayoutManager = GridLayoutManager(this.context,2)
        subsadap.setSubjectClickListener(object : SubjectsAdapter.OnSubjectClickListener {
            override fun onSubjectClick(position: Int) {
                var intent = Intent(context, QRgenerator::class.java)
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
            }

            override fun onFailure(call: Call<SubjectsResponse>, t: Throwable) {
            }

        })
        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}