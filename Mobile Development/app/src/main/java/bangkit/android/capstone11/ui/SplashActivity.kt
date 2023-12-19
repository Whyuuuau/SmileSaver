package bangkit.android.capstone11.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import bangkit.android.capstone11.R
import bangkit.android.capstone11.databinding.ActivitySplashBinding
import bangkit.android.capstone11.ui.preferences.UserManager
import java.util.Locale

class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    private lateinit var preferences: UserManager
    private val splashTimeOut: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSplash()
        setupProperty()
        setupView()

    }

    private fun setupSplash(){
        Handler().postDelayed({
            checkSession()
        }, splashTimeOut)
    }

    private fun setupProperty(){
        preferences = UserManager(this)
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

    private fun checkSession() {
        if (!preferences.getToken().isNullOrEmpty()) {
            startActivity(Intent(this, HomePageActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        }
    }

}