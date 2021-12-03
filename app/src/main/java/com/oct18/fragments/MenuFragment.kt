package com.oct18.fragments

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.oct18.R
import com.oct18.databinding.FragmentMenuBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding:FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // only in fragment
        setHasOptionsMenu(true)
        binding= FragmentMenuBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1.
        registerForContextMenu(binding.btnContext)

        binding.btnPopup.setOnClickListener {
            showMyPopupMenu(it)
        }
    }

    private fun showMyPopupMenu(view: View?) {
        val popup=PopupMenu(requireContext(),view)
        popup.menuInflater.inflate(R.menu.app_menu,popup.menu)
        popup.setOnMenuItemClickListener {
            when(it.itemId)
            {
                R.id.action_file->{
                    showMyToast("File is Selected")
                    true
                }
                R.id.action_edit->{
                    showMyToast("Edit is Selected")
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        requireActivity().menuInflater.inflate(R.menu.app_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.action_file->{
                showMyToast("File is Selected")
                return true
            }
            R.id.action_edit->{
                showMyToast("Edit is Selected")
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_menu,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.action_file->{
                showMyToast("File is Selected")
                return true
            }
            R.id.action_edit->{
                showMyToast("Edit is Selected")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showMyToast(msg: String) {
        Toast.makeText(requireContext(),msg,Toast.LENGTH_LONG).show()
    }

}