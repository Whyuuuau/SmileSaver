package com.example.toothscan.page

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.toothscan.databinding.ActivityWelcomeBinding
import com.example.toothscan.preferences.LanguageManager
import java.util.Locale

class  WelcomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWelcomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLanguage()
        setupView()
        setupAction()
        playAnimation()

    }

    private fun setupLanguage() {
        val language = LanguageManager.getLanguage(this)

        val config = resources.configuration
        config.setLocale(Locale(language))
        resources.updateConfiguration(config, resources.displayMetrics)
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
    }

    private fun setupAction() {
        binding.btnWelcomeLogin.setOnClickListener {
            startActivity(Intent(this, LoginPageActivity::class.java))
        }

        binding.btnWelcomeSignup.setOnClickListener {
            startActivity(Intent(this, SignUpPageActivity::class.java))
        }
    }


    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imgWelcome, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val login = ObjectAnimator.ofFloat(binding.btnWelcomeLogin, View.ALPHA, 1f).setDuration(500)
        val signup = ObjectAnimator.ofFloat(binding.btnWelcomeSignup, View.ALPHA, 1f).setDuration(500)
        val title = ObjectAnimator.ofFloat(binding.txtWelcomeTit, View.ALPHA, 1f).setDuration(500)
        val desc = ObjectAnimator.ofFloat(binding.txtWelcomeDesc, View.ALPHA, 1f).setDuration(500)
        val ors = ObjectAnimator.ofFloat(binding.txtWelcomeOr, View.ALPHA, 1f).setDuration(500)


        val together = AnimatorSet().apply {
            playTogether(login, signup, ors)
        }

        AnimatorSet().apply {
            playSequentially(title, desc, together)
            start()
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }

}