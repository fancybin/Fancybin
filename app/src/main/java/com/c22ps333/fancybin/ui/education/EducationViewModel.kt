package com.c22ps333.fancybin.ui.education

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EducationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Education Fragment"
    }
    val text: LiveData<String> = _text
}