package com.oct18.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.oct18.R
import com.oct18.WebViewActivity
import com.oct18.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentHomeBinding

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
        binding= FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title="Home"

        binding.btnRecyclerView.setOnClickListener(this)
        binding.btnEditText.setOnClickListener(this)
        binding.btnRadioButton.setOnClickListener(this)
        binding.btnCheckbox.setOnClickListener(this)
        binding.btnSeekbar.setOnClickListener(this)
        binding.btnWebview.setOnClickListener(this)
        binding.btnSpinner.setOnClickListener(this)
        binding.btnListview.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val fragment:Fragment? = when(v!!.id){
            R.id.btn_recycler_view-> RecyclerViewFragment()
            R.id.btn_edit_text->EditTextFragment()
            R.id.btn_radio_button->RadioButtonFragment()
            R.id.btn_checkbox->CheckboxFragment()
            R.id.btn_seekbar->SeekbarFragment()
            R.id.btn_spinner->SpinnnerFragment()
            R.id.btn_listview->ListviewFragment()
            R.id.btn_webview->{
                startActivity(Intent(requireContext(),WebViewActivity::class.java))
                null
            }
            else->null
        }
        if(fragment!=null) {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(HomeFragment::class.java.name)
                .commit()
        }
    }
}