package com.oct18.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.view.isVisible
import com.oct18.R
import com.oct18.databinding.FragmentCheckboxBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckboxFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckboxFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentCheckboxBinding

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
        binding= FragmentCheckboxBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CheckboxFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckboxFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cbShowHide.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                // show
                binding.layoutBox.visibility=View.VISIBLE
                binding.cbShowHide.text="Hide"
            }else{
                // hide
                binding.layoutBox.visibility=View.GONE
                binding.cbShowHide.text="Show"
            }
        }

        binding.swShowHide.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                // show
                binding.layoutBox.visibility=View.VISIBLE
                binding.swShowHide.text="Hide"
            }else{
                // hide
                binding.layoutBox.visibility=View.GONE
                binding.swShowHide.text="Show"
            }
        }

        binding.toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                // show
                binding.layoutBox.visibility=View.VISIBLE
            }else{
                // hide
                binding.layoutBox.visibility=View.GONE
            }
        }
    }
}