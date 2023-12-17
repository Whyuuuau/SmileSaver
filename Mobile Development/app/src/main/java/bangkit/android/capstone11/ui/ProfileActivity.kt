package bangkit.android.capstone11.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import bangkit.android.capstone11.R
import androidx.appcompat.app.AlertDialog
import bangkit.android.capstone11.databinding.ActivityHomePageBinding
import bangkit.android.capstone11.ui.preferences.UserManager
import bangkit.android.capstone11.databinding.ActivityProfileBinding
import bangkit.android.capstone11.ui.view_model.ViewModelFactory


class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var preferences: UserManager
    private lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
        setupView()
        setupProperty()
        profileSetup()
    }

    private fun setupAction() {
        binding.btnEdit.setOnClickListener {
            startActivity(Intent(this, UpdateActivity::class.java))
        }
        binding.btnLogout.setOnClickListener {
            dialogLogout()
        }
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, HomePageActivity::class.java))
        }
    }

    private fun profileSetup(){
        binding.avaEmailUser.text = preferences.getEmail()
        binding.avaUser.text = preferences.getUsername()
    }

    private fun setupView() {
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

    private fun setupProperty(){
        factory = ViewModelFactory.getInstance(this)
        preferences = UserManager(this)
    }

    private fun dialogLogout() {
        AlertDialog.Builder(this).apply {
            setTitle(R.string.logout_tit)
            setMessage(R.string.logout_con)
            setCancelable(false)
            setPositiveButton("Ok") { _, _ ->
                preferences.setToken("")
                startActivity(Intent(this@ProfileActivity, WelcomeActivity::class.java))
                finish()
            }
            setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            create()
            show()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, HomePageActivity::class.java)
        startActivity(intent)
        finish()
    }
}


