package bangkit.android.capstone11.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bangkit.android.capstone11.R
import bangkit.android.capstone11.databinding.ActivityKidsDataBinding
import com.bumptech.glide.Glide

class KidsDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKidsDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKidsDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //btnBack
        binding.btnBack.setOnClickListener {navigateActivity(HomePageActivity::class.java)}

        //cardView
        cardSetup()

        //btnCheckup
        binding.btnCheckup.setOnClickListener { navigateActivity(SelectActivity::class.java) }

        //btnNearestDentist
        binding.btnNearestDentist.setOnClickListener {navigateActivity(NearestDentistActivity::class.java) }

        //bottomBar
        bottomBarSetup()

    }

    private fun cardSetup() {
        val kidsName = intent.getStringExtra(EXTRA_NAME)
        val kidsAge = intent.getStringExtra(EXTRA_AGE)
        val kidsGender = intent.getStringExtra(EXTRA_GENDER)

        binding.tvKidsDataName.text = kidsName
        binding.tvKidsDataAge.text = "${kidsAge} tahun"
        binding.tvKidsDataGender.text = kidsGender

        if (kidsGender == getString(R.string.female)) {
            Glide.with(this)
                .load(R.drawable.ic_girl)
                .into(binding.ivAvatar)
        } else {
            Glide.with(this)
                .load(R.drawable.ic_boy)
                .into(binding.ivAvatar)
        }
    }

    private fun navigateActivity(targetActivity: Class<*>) {
        val kidsName = intent.getStringExtra(EXTRA_NAME)
        val kidsAge = intent.getStringExtra(EXTRA_AGE)
        val kidsGender = intent.getStringExtra(EXTRA_GENDER)
        val kidsToothBrushFrequency = intent.getStringExtra(EXTRA_TOOTH_BRUSH_FREQUENCY)

        val intent = Intent(this@KidsDataActivity, targetActivity)
        intent.putExtra(EXTRA_NAME, kidsName)
        intent.putExtra(EXTRA_AGE, kidsAge)
        intent.putExtra(EXTRA_GENDER, kidsGender)
        intent.putExtra(EXTRA_TOOTH_BRUSH_FREQUENCY, kidsToothBrushFrequency)
        startActivity(intent)
    }

    private fun bottomBarSetup() {
        val bottomBar = binding.bottomBar
        bottomBar.selectedItemId = R.id.navigation_checkup
        bottomBar.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this@KidsDataActivity, HomePageActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_checkup -> {
                    startActivity(Intent(this@KidsDataActivity, AddKidsDataActivity::class.java))
                    return@setOnNavigationItemSelectedListener false
                }
                R.id.navigation_nearest_dentist -> {
                    startActivity(Intent(this@KidsDataActivity, NearestDentistActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    startActivity(Intent(this@KidsDataActivity, ProfileActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_profile"
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_GENDER = "extra_gender"
        const val EXTRA_TOOTH_BRUSH_FREQUENCY = "extra_tooth_brush_frequency"
    }

}