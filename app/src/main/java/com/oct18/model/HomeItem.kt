package com.oct18.model

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.oct18.WebViewActivity


data class HomeItem(
    val title:String,
    val fragment:Fragment?,
    val activity: AppCompatActivity?
)
