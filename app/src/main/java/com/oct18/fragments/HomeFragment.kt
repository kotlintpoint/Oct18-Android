package com.oct18.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.oct18.R
import com.oct18.ViewModelActivity
import com.oct18.WebViewActivity
import com.oct18.adapter.HomeItemAdapter
import com.oct18.databinding.FragmentHomeBinding
import com.oct18.model.HomeItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
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

        binding.recyclerView.layoutManager=
            LinearLayoutManager(requireContext())

        val data= arrayListOf<HomeItem>(
            HomeItem("View Model",null,ViewModelActivity(),null),
            HomeItem("Menus",MenuFragment(),null,R.id.action_homeFragment_to_menuFragment),
            HomeItem("Dialogs",DialogsFragment(),null,R.id.action_homeFragment_to_dialogsFragment),
            HomeItem("RecyclerView",RecyclerViewFragment(),null,R.id.action_homeFragment_to_recyclerViewFragment),
            HomeItem("Edit Text",EditTextFragment(),null,null),
            HomeItem("Radio Button",RadioButtonFragment(),null,null),
            HomeItem("Check box",CheckboxFragment(),null,null),
            HomeItem("Seekbar",SeekbarFragment(),null,null),
            HomeItem("WebView",null, WebViewActivity(),null),
            HomeItem("Spinner",SpinnnerFragment(), null,null),
            HomeItem("List View",ListviewFragment(), null,null),
        )

        val adapter=HomeItemAdapter(data, object : HomeItemAdapter.OnHomeItemClickListener {
            override fun onHomeItemClick(item: HomeItem) {
                if(item.fragment!=null){
                    /*parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, item.fragment)
                        .addToBackStack(HomeFragment::class.java.name)
                        .commit()*/
                    Navigation.findNavController(view).navigate(item.destinationId!!)
                } else{
                    startActivity(Intent(requireContext(),item.activity!!::class.java))
                }
            }
        })
        binding.recyclerView.adapter=adapter
    }

}