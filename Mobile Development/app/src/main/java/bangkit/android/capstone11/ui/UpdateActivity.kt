package bangkit.android.capstone11.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import bangkit.android.capstone11.R
import bangkit.android.capstone11.data.ResultResource
import bangkit.android.capstone11.databinding.ActivityUpdateBinding
import bangkit.android.capstone11.ui.preferences.UserManager
import bangkit.android.capstone11.ui.user_utils.hide
import bangkit.android.capstone11.ui.user_utils.show
import bangkit.android.capstone11.ui.view_model.UpdateViewModel
import bangkit.android.capstone11.ui.view_model.ViewModelFactory

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var preferences: UserManager
    private lateinit var factory: ViewModelFactory
    private val viewModel: UpdateViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.hide()
        setupAction()
        setupView()
        setupProperty()
        profileSetup()
    }

    private fun setupAction() {
        binding.btnSave.setOnClickListener {upedate()}
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, HomePageActivity::class.java))
        }
    }

    private fun upedate(){ Log.d("id", preferences.getID().toString())
        val username=binding.edtUsername.text.toString()
        viewModel.update(preferences.getID(),username,preferences.getEmail()).observe(this){ response ->
            if (response != null) {
                when (response) {
                    is ResultResource.Loading -> {
                        binding.progressBar.show()
                    }
                    is ResultResource.Success -> {
                        binding.progressBar.hide()
                        val data = response.data
                        val intent = Intent(this@UpdateActivity, HomePageActivity::class.java)
                        showSuccessDialog()
                        Log.d("success", data.id.toString())
                        preferences.setUsername(data.username)
                        startActivity(intent)
                    }
                    is ResultResource.Error -> {
                        binding.progressBar.hide()
                        Log.d("error", response.error)
                        showErrorDialog()
                    }

                    else -> {}
                }
            }
        }
    }

    private fun showErrorDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.update_tit_dialogerr)
        builder.setMessage(R.string.update_con_dialogerr)
        builder.setPositiveButton("OK") { _, _ ->
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun showSuccessDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.update_tit_dialog)
        builder.setMessage(R.string.update_con_dialog)
        builder.setPositiveButton("OK") { _, _ ->
            val intent = Intent(this, HomePageActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun profileSetup(){
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

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, HomePageActivity::class.java)
        startActivity(intent)
        finish()
    }
}