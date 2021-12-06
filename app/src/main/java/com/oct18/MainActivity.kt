package com.oct18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.oct18.databinding.ActivityMainBinding
import com.oct18.fragments.LoginFragment

class MainActivity : AppCompatActivity() {

    //logt
    private val TAG = "MainActivity"
    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

}