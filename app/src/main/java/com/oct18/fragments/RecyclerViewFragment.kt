package com.oct18.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.oct18.R
import com.oct18.adapter.StudentAdapter
import com.oct18.databinding.FragmentRecyclerViewBinding
import com.oct18.model.Student
import java.util.ArrayList

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
    private lateinit var data: ArrayList<Student>

    // TODO: Rename and change types of parameters
    private lateinit var binding:FragmentRecyclerViewBinding
    private lateinit var adapter: StudentAdapter;
    private var actionMode:ActionMode? = null

    val actionModeCallback= object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            val inflater: MenuInflater = mode!!.menuInflater
            inflater.inflate(R.menu.user_menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            return when (item!!.itemId) {
                R.id.action_delete -> {
                    //Delete Selected Items
                    val tempData=data.filter { !it.isSelected }
                    data= tempData as ArrayList<Student>
                    adapter.data=data
                    adapter.notifyDataSetChanged()

                    mode!!.finish() // Action picked, so close the CAB
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
        }

    }

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
            setHasOptionsMenu(true)

        // 1. setLayoutManager
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        //binding.recyclerView.layoutManager=GridLayoutManager(requireContext(),2)
        //binding.recyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        //binding.recyclerView.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,true)

        //2. Create Model class

        //3. Prepare data list
        data= arrayListOf<Student>()

        //4. Create Adapter class

        //5. Pass data to adapter class 1) Constructor 2) method
        adapter = StudentAdapter(data, object : StudentAdapter.OnStudentClickListener {
            override fun onStudentClick(student: Student) {
                Log.i(TAG, student.toString())
                if(actionMode==null) {
                    data.remove(student)
                    adapter.notifyDataSetChanged()
                }else{
                    student.isSelected=!student.isSelected
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onStudentLongClick(student: Student) {
                when (actionMode) {
                    null -> {
                        // Start the CAB using the ActionMode.Callback defined above
                        actionMode = activity?.startActionMode(actionModeCallback)
                        student.isSelected=true
                        adapter.notifyDataSetChanged()
                        true
                    }
                    else -> false
                }
            }
        })
        // 6. Set adapter
        binding.recyclerView.adapter=adapter


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.user_new_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.action_new){
            Navigation.findNavController(requireView())
                .navigate(R.id.action_recyclerViewFragment_to_studentFormFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}