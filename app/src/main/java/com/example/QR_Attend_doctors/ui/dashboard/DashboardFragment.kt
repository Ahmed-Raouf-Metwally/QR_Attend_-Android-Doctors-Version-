package com.example.QR_Attend_doctors.ui.dashboard
import androidx.lifecycle.ViewModelProvider
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.QR_Attend_doctors.R
import com.example.QR_Attend_doctors.databinding.FragmentHomeBinding
import com.example.QR_Attend_doctors.ui.Adapters.SubjectsAdapter
import com.example.QR_Attend_doctors.ui.Adapters.SubjectsData
import com.example.QR_Attend_doctors.user.Lessons

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
        subsadap = SubjectsAdapter(subsList)
        subsrecy.adapter = subsadap
        subsadap.setSubjectClickListener(object : SubjectsAdapter.OnSubjectClickListener {
            override fun onSubjectClick(position: Int) {
                var intent = Intent(context, Lessons::class.java)
                startActivity(intent)
            }

        })
    }

    lateinit var  subsList : MutableList<SubjectsData>
    fun creat(){
subsList= mutableListOf()
        for (i in 1..2) {
            subsList.add(
                SubjectsData(
                    subjectName = "electronics",
                    backGroundImageDAsh = R.drawable.background4,
                    progress = "60 %"
                )
            )
            subsList.add(
                SubjectsData(
                    subjectName = "computer vision",
                    backGroundImageDAsh = R.drawable.background2,
                    progress = "70 %"
                )
            )
            subsList.add(
                SubjectsData(
                    subjectName = "image processing",
                    backGroundImageDAsh = R.drawable.background3,
                    progress = "80 %"
                )
            )
            subsList.add(
                SubjectsData(
                    subjectName = "logic design",
                    backGroundImageDAsh = R.drawable.background4,
                    progress = "90 %"
                )
            )
            subsList.add(
                SubjectsData(
                    subjectName = "Genetic Algorithm",
                    backGroundImageDAsh = R.drawable.background5,
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
