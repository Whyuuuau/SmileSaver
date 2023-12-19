package bangkit.android.capstone11.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import bangkit.android.capstone11.databinding.ActivityLoginPageBinding
import bangkit.android.capstone11.ui.user_utils.hide
import bangkit.android.capstone11.R
import bangkit.android.capstone11.data.ResultResource
import bangkit.android.capstone11.ui.view_model.ViewModelFactory
import bangkit.android.capstone11.ui.preferences.UserManager
import bangkit.android.capstone11.ui.user_utils.show
import bangkit.android.capstone11.ui.view_model.LoginViewModel

class LoginPageActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginPageBinding
    private lateinit var preferences: UserManager
    private lateinit var factory: ViewModelFactory
    private val viewModel: LoginViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.hide()

        setupView()
        setupAction()
        setupProperty()
        playAnimation()
        setupKeyboardClosing()

    }

    private fun setupAction() {
        binding.btnBackLogin.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

        binding.txtSignup.setOnClickListener {
            startActivity(Intent(this, SignUpPageActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            validate()
        }

        val edLoginPassword = binding.edLoginPassword
        val icShowPass = binding.icShowPass
        binding.icShowPass.setOnClickListener{
            togglePasswordVisibility(edLoginPassword, icShowPass)
        }
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

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imgLogin, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title = ObjectAnimator.ofFloat(binding.loginTitle, View.ALPHA, 1f).setDuration(300)
        val desc = ObjectAnimator.ofFloat(binding.loginDesc, View.ALPHA, 1f).setDuration(300)
        val emailTextView = ObjectAnimator.ofFloat(binding.loginMsgEmail, View.ALPHA, 1f).setDuration(300)
        val emailEditTextLayout = ObjectAnimator.ofFloat(binding.loginInptEmail, View.ALPHA, 1f).setDuration(300)
        val passwordTextView = ObjectAnimator.ofFloat(binding.loginMsgPass, View.ALPHA, 1f).setDuration(300)
        val passwordEditTextLayout = ObjectAnimator.ofFloat(binding.loginInptPass, View.ALPHA, 1f).setDuration(300)
        val login = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(300)
        val register = ObjectAnimator.ofFloat(binding.loginSignup, View.ALPHA, 1f).setDuration(300)


        AnimatorSet().apply {
            playSequentially(
                title,
                desc,
                emailTextView,
                emailEditTextLayout,
                passwordTextView,
                passwordEditTextLayout,
                login,
                register
            )
            startDelay = 100
        }.start()
    }

    private fun togglePasswordVisibility(edLoginPassword: EditText, icShowPass: ImageView) {
        val inputType = if (edLoginPassword.inputType == (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
            InputType.TYPE_CLASS_TEXT
        } else {
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        edLoginPassword.inputType = inputType
        val font = ResourcesCompat.getFont(this, R.font.nunito_regular)
        edLoginPassword.typeface = font
        icShowPass.setImageResource(if (inputType == InputType.TYPE_CLASS_TEXT) R.drawable.ic_visible else R.drawable.ic_invisible)
        edLoginPassword.setSelection(edLoginPassword.text.length)
    }

    // email adalah username
    private fun login() {
        val email = binding.edLoginEmail.text.toString()
        val password = binding.edLoginPassword.text.toString()

        viewModel.login(email, password).observe(this) { response ->
            if (response != null) {
                when (response) {
                    is ResultResource.Loading -> {
                        binding.progressBar.show()
                    }
                    is ResultResource.Success -> {
                        binding.progressBar.hide()
                        val data = response.data
                        val intent = Intent(this@LoginPageActivity, HomePageActivity::class.java)
                        showSuccessDialog()
                        preferences.setID(data.id.toString())
                        preferences.setToken(data.accessToken)
                        preferences.setEmail(data.email)
                        preferences.setUsername(data.username)
                        Log.d("success", data.id.toString())
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


    private fun validate() {
        val email = binding.edLoginEmail.text.toString()
        val password = binding.edLoginPassword.text.toString()

        when {
//            email.isEmpty() -> {
//                binding.edLoginEmail.error = "Input Your Email"
//                binding.edLoginEmail.requestFocus()
//            }
            password.isEmpty() -> {
                binding.edLoginPassword.error = "Input Your Password"
                binding.edLoginPassword.requestFocus()
            }
            else -> {
                login()
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupKeyboardClosing() {
        val rootLayout = findViewById<View>(android.R.id.content)
        rootLayout.setOnTouchListener { _, _ ->
            currentFocus?.let { focusedView ->
                val imm = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(focusedView.windowToken, 0)
                focusedView.clearFocus()
            }
            false
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showSuccessDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.login_tit_dialog)
        builder.setMessage(R.string.login_con_dialog)
        builder.setPositiveButton("OK") { _, _ ->
            val intent = Intent(this, HomePageActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun showErrorDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.login_tit_dialogerr)
        builder.setMessage(R.string.login_con_dialogerr)
        builder.setPositiveButton("OK") { _, _ ->
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun setupProperty(){
        factory = ViewModelFactory.getInstance(this)
        preferences = UserManager(this)
    }
}