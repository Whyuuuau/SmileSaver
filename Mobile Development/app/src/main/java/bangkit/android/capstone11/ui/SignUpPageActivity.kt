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
import bangkit.android.capstone11.R
import bangkit.android.capstone11.data.ResultResource
import bangkit.android.capstone11.databinding.ActivitySignUpPageBinding
import bangkit.android.capstone11.ui.user_utils.hide
import bangkit.android.capstone11.ui.user_utils.show
import bangkit.android.capstone11.ui.view_model.SignUpViewModel
import bangkit.android.capstone11.ui.view_model.ViewModelFactory
import java.util.regex.Pattern

class SignUpPageActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpPageBinding
    private lateinit var factory: ViewModelFactory
    private val viewModel: SignUpViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.hide()

        setupView()
        setupAction()
        setupProperty()
        playAnimation()
        setupKeyboardClosing()

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

    private fun setupAction() {
        binding.btnBackSignup.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        }

        binding.txtSignup.setOnClickListener {
            startActivity(Intent(this, LoginPageActivity::class.java))
            finish()
        }

        val edRegisPassword = binding.edRegisterPassword
        val icShowPass = binding.icShowPass
        binding.icShowPass.setOnClickListener{
            togglePasswordVisibility(edRegisPassword, icShowPass)
        }

        binding.btnSignup.setOnClickListener {
            validate()
        }
    }

    private fun playAnimation() {
        val animatorSet = AnimatorSet()

        val imgSignupAnimator = ObjectAnimator.ofFloat(binding.imgSignup, View.TRANSLATION_X, -30f, 30f)
        imgSignupAnimator.apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }

        val viewsToAnimate = listOf(
            binding.signupTitle,
            binding.signupDesc,
            binding.signupMsgName,
            binding.signupInptName,
            binding.signupMsgEmail,
            binding.signupInptEmail,
            binding.signupMsgPass,
            binding.signupInptPass,
            binding.btnSignup,
            binding.signupSignup
        )

        val alphaAnimators = viewsToAnimate.map { ObjectAnimator.ofFloat(it, View.ALPHA, 1f) }
        alphaAnimators.forEach { it.duration = 300 }

        animatorSet.playTogether(imgSignupAnimator, *alphaAnimators.toTypedArray())
        animatorSet.startDelay = 100
        animatorSet.start()
    }

    private fun setupProperty() {
        factory = ViewModelFactory.getInstance(this)
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

    private fun validate() {
        val name = binding.edRegisterName.text.toString()
        val email = binding.edRegisterEmail.text.toString()
        val password = binding.edRegisterPassword.text.toString()

        when {
            name.isEmpty() -> {
                binding.edRegisterName.error = "Input Your Name"
                binding.edRegisterName.requestFocus()
            }
            email.isEmpty() -> {
                binding.edRegisterEmail.error = "Input Your Email"
                binding.edRegisterEmail.requestFocus()
            }
            !isEmailValid(email) -> {
                binding.edRegisterEmail.error = "Invalid Email Address"
                binding.edRegisterEmail.requestFocus()
            }
            password.isEmpty() -> {
                binding.edRegisterPassword.error = "Input your Password"
                binding.edRegisterPassword.requestFocus()
            }
            else -> {
                register()
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        val pattern = Pattern.compile(
            "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,4})+\$",
            Pattern.CASE_INSENSITIVE
        )
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    private fun register() {
        val name = binding.edRegisterName.text.toString()
        val email = binding.edRegisterEmail.text.toString()
        val password = binding.edRegisterPassword.text.toString()

        viewModel.register(name, email, password).observe(this) { response ->
            when (response) {
                is ResultResource.Loading -> {
                    binding.progressBar.show()
                }

                is ResultResource.Success -> {
                    binding.progressBar.hide()
                    showSuccessDialog()
                    startActivity(Intent(this, LoginPageActivity::class.java))
                }

                is ResultResource.Error -> {
                    binding.progressBar.hide()
                    Log.d("error", response.error)
                }

                else -> {}
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
        builder.setTitle(R.string.regis_tit_dialog)
        builder.setMessage(R.string.regis_con_dialog)
        builder.setPositiveButton("OK") { _, _ ->
            startActivity(Intent(this, LoginPageActivity::class.java))
            finish()
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun showErrorDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.regis_tit_dialogerr)
        builder.setMessage(R.string.regis_con_dialogerr)
        builder.setPositiveButton("OK") { _, _ -> }
        val dialog = builder.create()
        dialog.show()
    }

}

