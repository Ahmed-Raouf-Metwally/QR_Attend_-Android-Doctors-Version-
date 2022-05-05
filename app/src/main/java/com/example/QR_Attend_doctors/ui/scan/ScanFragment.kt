package com.example.QR_Attend_doctors.ui.scan

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.QR_Attend_doctors.QRgenerator
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.databinding.FragmentGalleryBinding
import com.example.QR_Attend_doctors.ui.Adapters.SubjectsAdapter
import com.example.QR_Attend_doctors.ui.Adapters.SubjectsData

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
        subsadap = SubjectsAdapter(subsList)
        subsrecy.adapter = subsadap
        val gridLayout:GridLayoutManager = GridLayoutManager(this.context,2)
        subsadap.setSubjectClickListener(object : SubjectsAdapter.OnSubjectClickListener {
            override fun onSubjectClick(position: Int) {
                var intent = Intent(context, QRgenerator::class.java)
                startActivity(intent)
            }

        })


    }

    lateinit var  subsList : MutableList<SubjectsData>
    fun creat(){
        subsList= mutableListOf()
        for (i in 1..10) {
            subsList.add(
                SubjectsData(
                    subjectName = "electronics",
                    backGroundImageDAsh = R.drawable.cs_logo,
                    progress = "60 %"
                )
            )
            subsList.add(
                SubjectsData(
                    subjectName = "computer vision",
                    backGroundImageDAsh = R.drawable.cs_logo,
                    progress = "70 %"
                )
            )
            subsList.add(
                SubjectsData(
                    subjectName = "image processing",
                    backGroundImageDAsh = R.drawable.cs_logo,
                    progress = "80 %"
                )
            )
            subsList.add(
                SubjectsData(
                    subjectName = "logic design",
                    backGroundImageDAsh = R.drawable.cs_logo,
                    progress = "90 %"
                )
            )
            subsList.add(
                SubjectsData(
                    subjectName = "Genetic Algorithm",
                    backGroundImageDAsh = R.drawable.cs_logo,
                    progress = "95 %"
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}