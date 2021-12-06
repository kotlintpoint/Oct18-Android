package com.oct18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.oct18.databinding.ActivityViewModelBinding
import com.oct18.model.CountViewModel

class ViewModelActivity : AppCompatActivity() {

    //private var count=1
    private lateinit var binding:ActivityViewModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model:CountViewModel by viewModels()
        model.getCount().observe(this, object : Observer<Int> {
            override fun onChanged(value: Int?) {
                binding.tvCount.text="Count : $value"
            }
        })

        //binding.tvCount.text="Count : $count"
        binding.btnIncrement.setOnClickListener {
            //count++
            //binding.tvCount.text="Count : $count"

            model.incrementCount()
        }
    }
}