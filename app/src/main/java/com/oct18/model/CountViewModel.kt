package com.oct18.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {

    private val count:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            value=1
        }
    }

    fun getCount():LiveData<Int> = count

    fun incrementCount(){
        count.value = count.value!! + 1
    }
}