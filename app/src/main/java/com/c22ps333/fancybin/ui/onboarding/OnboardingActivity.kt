package com.c22ps333.fancybin.ui.onboarding

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.c22ps333.fancybin.databinding.ActivityOnboardingBinding
import com.c22ps333.fancybin.ui.ViewModelFactory
import com.c22ps333.fancybin.ui.model.UserPreferences
import com.c22ps333.fancybin.ui.welcome.WelcomeActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")

class OnboardingActivity : AppCompatActivity() {

    private val binding: ActivityOnboardingBinding by lazy {
        ActivityOnboardingBinding.inflate(layoutInflater)
    }

    private val viewModel: OnboardingViewModel by viewModels {
        ViewModelFactory.getInstance(
            UserPreferences.getInstance(dataStore))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
        setupAction()
    }

    private fun setupAction() {
        binding.btnStarted.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            viewModel.setFirstTime(false)
            startActivity(intent)
            finish()
        }
    }
}