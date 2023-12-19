package bangkit.android.capstone11.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bangkit.android.capstone11.R
import bangkit.android.capstone11.databinding.ActivityAddKidsDataBinding

class AddKidsDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddKidsDataBinding
    private lateinit var kidsGender: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddKidsDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //btnBack
        binding.btnBack.setOnClickListener {btnBackAction()}

        //radiogroup
        radioGroupSetup()

        //btnSave
        binding.btnSave.setOnClickListener {btnSaveAction() }

        //bottomBar
        setupBottomBar()

    }

    private fun radioGroupSetup() {
        val selectedColor = getColor(R.color.dark_blue)
        val defaultColor = getColor(R.color.grey)
        binding.rbFemale.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                kidsGender = getString(R.string.female)
                binding.rbFemale.setTextColor(selectedColor)
            } else {
                kidsGender = getString(R.string.male)
                binding.rbFemale.setTextColor(defaultColor)
            }
        }
        binding.rbMale.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                kidsGender = getString(R.string.male)
                binding.rbMale.setTextColor(selectedColor)
            } else {
                kidsGender = getString(R.string.female)
                binding.rbMale.setTextColor(defaultColor)
            }
        }
    }

    private fun btnSaveAction() {
        val kidsName = binding.edFullName.text.toString()
        val kidsAge = binding.edAge.text.toString()
        val kidsToothBrushFrequency = binding.edToothbrushFrequency.text.toString()

        val intent = Intent(this@AddKidsDataActivity, KidsDataActivity::class.java)
        intent.putExtra(KidsDataActivity.EXTRA_NAME, kidsName)
        intent.putExtra(KidsDataActivity.EXTRA_AGE, kidsAge)
        intent.putExtra(KidsDataActivity.EXTRA_GENDER, kidsGender)
        intent.putExtra(KidsDataActivity.EXTRA_TOOTH_BRUSH_FREQUENCY, kidsToothBrushFrequency)
        startActivity(intent)

    }

    private fun setupBottomBar() {
        val bottomBar = binding.bottomBar
        bottomBar.selectedItemId = R.id.navigation_checkup
        bottomBar.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this@AddKidsDataActivity, HomePageActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_checkup -> {
                    return@setOnNavigationItemSelectedListener false
                }
                R.id.navigation_nearest_dentist -> {
                    startActivity(Intent(this@AddKidsDataActivity, NearestDentistActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    startActivity(Intent(this@AddKidsDataActivity, ProfileActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    private fun btnBackAction() {
        startActivity(Intent(this@AddKidsDataActivity, HomePageActivity::class.java))
    }

}