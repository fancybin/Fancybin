package com.c22ps333.fancybin.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.c22ps333.fancybin.ui.model.UserPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnboardingViewModel(private val pref: UserPreferences) : ViewModel() {

    fun setFirstTime(firstTime: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            pref.setFirstTime(firstTime)
        }
    }
}