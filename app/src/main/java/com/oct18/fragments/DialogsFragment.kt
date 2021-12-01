package com.oct18.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.oct18.R
import com.oct18.databinding.FragmentDialogsBinding
import java.util.*

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
            showMyToast("This is Toast")
        }

        binding.btnAlert.setOnClickListener {
            val builder=AlertDialog.Builder(requireContext())
            builder.setTitle(getString(R.string.app_name))
                .setMessage("Are you Sure?")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Yes"
                ) { _, _ ->
                    showMyToast("Yes is Clicked!!!")
                }
                .setNegativeButton("No"){
                    dialog, which->
                    showMyToast("No is Clicked!!!")
                }
                .setNeutralButton("Cancel"){
                        dialog, which->
                    showMyToast("Cancel is Clicked!!!")
                }
            val dialog=builder.create()
            dialog.show()
        }

        binding.btnDate.setOnClickListener {

            val calendar=Calendar.getInstance()
            val year=calendar[Calendar.YEAR]
            val month=calendar[Calendar.MONTH]
            val dayOfMonth=calendar[Calendar.DAY_OF_MONTH]

            val listener=DatePickerDialog.OnDateSetListener { view, _year, _month, _dayOfMonth ->
                binding.btnDate.text="$_dayOfMonth - ${_month+1} - $_year"
            }

            val dialog=DatePickerDialog(
                requireContext(),
                listener,
                year,
                month,
                dayOfMonth
            )

            dialog.datePicker.maxDate=calendar.timeInMillis

            dialog.show()
        }

        binding.btnTime.setOnClickListener {
            val calendar=Calendar.getInstance()
            val hourOfDay=calendar[Calendar.HOUR_OF_DAY]
            val minute=calendar[Calendar.MINUTE]

            val listener= TimePickerDialog.OnTimeSetListener { view, _hourOfDay, _minute ->

                val time = if(_hourOfDay > 12) "${_hourOfDay-12} : $_minute PM" else "$_hourOfDay : $_minute AM"

                binding.btnTime.text=time
            }

            val dialog=TimePickerDialog(
                requireContext(),
                listener,
                hourOfDay,
                minute,
                false
            )

            dialog.show()
        }
        val states=requireContext().resources.getStringArray(R.array.states)
        val checkedItems=BooleanArray(states.size){false}

        binding.btnAlertList.setOnClickListener {

            val builder=AlertDialog.Builder(requireContext())
            builder.setTitle(getString(R.string.app_name))
                /*.setItems(R.array.states, object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        val selectedState=states[which]
                        binding.btnAlertList.text=selectedState
                    }
                })*/
                .setMultiChoiceItems(R.array.states,checkedItems, object : DialogInterface.OnMultiChoiceClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                        checkedItems[which]=isChecked
                    }
                })
                .setPositiveButton("Done"
                ) { dialog, which ->
                    val selectedStates= arrayListOf<String>()
                    for(index in checkedItems.indices){
                        if(checkedItems[index]) selectedStates.add(states[index])
                    }
                    binding.btnAlertList.text=selectedStates.toString()
                }
            val dialog=builder.create()
            dialog.show()
        }
    }

    private fun showMyToast(msg: String) {
        val toast= Toast.makeText(requireContext(),msg,Toast.LENGTH_LONG)
        //toast.duration=Toast.LENGTH_LONG
        //toast.setText("Hello Toast")
        toast.setGravity(Gravity.CENTER,0,0)
        toast.show()
    }


}