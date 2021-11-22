package com.oct18.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.oct18.R
import com.oct18.databinding.FragmentListviewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "ListviewFragment"

/**
 * A simple [Fragment] subclass.
 * Use the [ListviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListviewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentListviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    val cities = mapOf<String,ArrayList<String>>(
        "Gujarat" to arrayListOf<String>("Surat","Ahmedabad","Baroda"),
        "Maharastra" to arrayListOf<String>("Mumbai","Nagpur","Pune"),
        "Rajasthan" to arrayListOf<String>("Jaipur","Udaypur","Bikaner")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentListviewBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val states=resources.getStringArray(R.array.states)

        val adapter=ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,states)
        binding.listview.adapter=adapter

        binding.listview.onItemClickListener= object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedState=states[position]
                Log.i(TAG, selectedState)
                //setCityList(selectedState)
            }

        }
    }

    /*private fun setCityList(selectedState: String?) {
      val cityList= cities[selectedState]!!
        val adapter=
            ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,cityList)
        binding.listview.adapter=adapter
    }*/
}