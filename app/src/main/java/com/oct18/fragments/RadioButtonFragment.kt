package com.oct18.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import com.oct18.R
import com.oct18.databinding.FragmentRadioButtonBinding
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "RadioButtonFragment"

/**
 * A simple [Fragment] subclass.
 * Use the [RadioButtonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RadioButtonFragment : Fragment(), TextWatcher {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentRadioButtonBinding

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
        requireActivity().title="Radio Button"
        binding= FragmentRadioButtonBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etNumberOne.addTextChangedListener(this)
        binding.etNumberTwo.addTextChangedListener(this)

        binding.rgOperation.setOnCheckedChangeListener { _, checkedId ->
            doOperation(checkedId)
        }
    }

    private fun doOperation(checkedId: Int) {
        try{
            var no1=binding.etNumberOne.text.toString().toInt()
            var no2=binding.etNumberTwo.text.toString().toInt()
            var result=0
            when(checkedId){
                R.id.rb_add-> {
                    Log.i(TAG, "Add")
                    result=no1+no2
                }
                R.id.rb_sub-> {
                    Log.i(TAG, "Sub")
                    result=no1-no2
                }
                R.id.rb_mul-> {
                    Log.i(TAG, "Mul")
                    result=no1*no2
                }
                R.id.rb_div-> {
                    Log.i(TAG, "Div")
                    result=no1/no2
                }
                else->Log.i(TAG, "Nothing")
            }
            binding.tvResult.text="Result : $result"
        }catch (ex:Exception){
            Log.i(TAG, ex.toString())
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        doOperation(binding.rgOperation.checkedRadioButtonId)
    }

    override fun afterTextChanged(s: Editable?) {

    }


}