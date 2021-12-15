package com.oct18.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.oct18.R
import com.oct18.databinding.FragmentStudentFormBinding
import com.oct18.db.AppDatabase
import com.oct18.db.DbUtils
import com.oct18.model.Student

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StudentFormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentFormFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding:FragmentStudentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        requireActivity().title="Student Form"
        binding= FragmentStudentFormBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnSave.setOnClickListener {
                //val db=DbUtils.getDatabase(requireContext())
                val db = Room.databaseBuilder(
                    requireContext(),
                    AppDatabase::class.java,
                    getString(R.string.app_name)
                ).allowMainThreadQueries()
                    .build()

                val dao=db.studentDao()

                val student= Student(
                    etId.text.toString().toInt(),
                    etFirstName.text.toString(),
                    etLastName.text.toString(),
                    etEmail.text.toString()
                )

                dao.insertStudent(student)
            }
        }

    }

}