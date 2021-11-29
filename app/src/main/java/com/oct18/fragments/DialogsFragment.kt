package com.oct18.fragments

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.oct18.R
import com.oct18.databinding.FragmentDialogsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding:FragmentDialogsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        requireActivity().title="Dialogs"
        binding= FragmentDialogsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToast.setOnClickListener {
            val toast= Toast.makeText(requireContext(),"Hello Toast!!!",Toast.LENGTH_LONG)
            //toast.duration=Toast.LENGTH_LONG
            //toast.setText("Hello Toast")
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
    }


}