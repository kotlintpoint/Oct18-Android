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
import com.oct18.databinding.FragmentSpinnnerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "SpinnnerFragment"

/**
 * A simple [Fragment] subclass.
 * Use the [SpinnnerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpinnnerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentSpinnnerBinding

    val cities = mapOf<String,ArrayList<String>>(
        "Gujarat" to arrayListOf<String>("Surat","Ahmedabad","Baroda"),
        "Maharastra" to arrayListOf<String>("Mumbai","Nagpur","Pune"),
        "Rajasthan" to arrayListOf<String>("Jaipur","Udaypur","Bikaner")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSpinnnerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val states=resources.getStringArray(R.array.states)

        binding.spStates.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedState=states[position]
                Log.i(TAG, selectedState)
                setCityList(selectedState)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    private fun setCityList(selectedState: String?) {
        val cityList = cities[selectedState]!!
        /* Adapter => bridge between data (array, arraylist) and view(spinner, listview, etc)
            ArrayAdapter => Simple Strings type of data
         */
        val adapter=ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,cityList)
        //val adapter=ArrayAdapter<String>(requireContext(),R.layout.city_item,cityList)
        binding.spCities.adapter=adapter

    }

}