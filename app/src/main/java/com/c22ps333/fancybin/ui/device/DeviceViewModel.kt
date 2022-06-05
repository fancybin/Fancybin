package com.c22ps333.fancybin.ui.device

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeviceViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Device Fragment"
    }
    val text: LiveData<String> = _text
}