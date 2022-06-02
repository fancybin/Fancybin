package com.c22ps333.fancybin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c22ps333.fancybin.ui.model.UserPreferences


class MainViewModel constructor(
    private val pref: UserPreferences
) : ViewModel() {

    fun checkIfFirstTime(): LiveData<Boolean> {
        return pref.isFirstTime().asLiveData()
    }
}