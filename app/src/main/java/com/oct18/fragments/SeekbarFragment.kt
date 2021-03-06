package com.oct18.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.oct18.R
import com.oct18.databinding.FragmentSeekbarBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "SeekbarFragment"

/**
 * A simple [Fragment] subclass.
 * Use the [SeekbarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SeekbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentSeekbarBinding

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
        binding= FragmentSeekbarBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sbRange.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.i(TAG, "On Progress Change")
                binding.tvProgress.text="Progress : $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.i(TAG, "start Tracking Touch")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.i(TAG, "Stop Tracking Touch")
            }

        })


        binding.sbRed.setOnSeekBarChangeListener(this)
        binding.sbGreen.setOnSeekBarChangeListener(this)
        binding.sbBlue.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        val red=binding.sbRed.progress
        val green=binding.sbGreen.progress
        val blue=binding.sbBlue.progress
        binding.layoutMain.setBackgroundColor(Color.rgb(red, green, blue))
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}