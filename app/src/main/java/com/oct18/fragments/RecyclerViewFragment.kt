package com.oct18.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.oct18.adapter.StudentAdapter
import com.oct18.databinding.FragmentRecyclerViewBinding
import com.oct18.model.Student

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "RecyclerViewFragment"

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding:FragmentRecyclerViewBinding
    private lateinit var adapter: StudentAdapter;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        requireActivity().title="RecyclerView"
        binding= FragmentRecyclerViewBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. setLayoutManager
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        //binding.recyclerView.layoutManager=GridLayoutManager(requireContext(),2)
        //binding.recyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        //binding.recyclerView.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,true)

        //2. Create Model class

        //3. Prepare data list
        val data= arrayListOf<Student>(
            Student("M","M","m@gmail.com"),
            Student("Prince","Prince","prince@gmail.com"),
            Student("Hiren","Hiren","hiren@gmail.com"),
            Student("Krishna","Krishna","krishna@gmail.com"),
            Student("Mansi","Mansi","mansi@gmail.com")
        )

        //4. Create Adapter class

        //5. Pass data to adapter class 1) Constructor 2) method
        adapter = StudentAdapter(data, object : StudentAdapter.OnStudentClickListener {
            override fun onStudentClick(student: Student) {
                Log.i(TAG, student.toString())
                data.remove(student)
                adapter.notifyDataSetChanged()
            }
        })
        // 6. Set adapter
        binding.recyclerView.adapter=adapter


    }

}