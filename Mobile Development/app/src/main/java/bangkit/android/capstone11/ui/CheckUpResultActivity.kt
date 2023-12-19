package bangkit.android.capstone11.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bangkit.android.capstone11.R
import bangkit.android.capstone11.databinding.ActivityCheckUpResultBinding
import com.bumptech.glide.Glide

class CheckUpResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckUpResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckUpResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bottomBack
        binding.btnNearestDentist.setOnClickListener {navigateActivity(AddKidsDataActivity::class.java)}

        //card
        cardSetup()

        //suggestionSetup
        suggestionSetup()

        //bottomBar
        setupBottomBar()

        //btnNearestDentist
        binding.btnNearestDentist.setOnClickListener {navigateActivity(NearestDentistActivity::class.java)}
    }

    private fun cardSetup() {
        val kidsName = intent.getStringExtra(KidsDataActivity.EXTRA_NAME)
        val kidsAge = intent.getStringExtra(KidsDataActivity.EXTRA_AGE)
        val kidsGender = intent.getStringExtra(KidsDataActivity.EXTRA_GENDER)
        val kidsResult = intent.getStringExtra(SelectActivity.EXTRA_RESULT)
        val kidsAccuracy = intent.getStringExtra(SelectActivity.EXTRA_ACCURACY)

        binding.tvKidsDataName.text = kidsName
        binding.tvKidsDataAge.text = "${kidsAge}tahun"
        binding.tvKidsDataGender.text = kidsGender
        binding.tvCheckupResult.text = kidsResult
        binding.tvAccuracyResult.text = "${kidsAccuracy}%"

        if (kidsGender == getString(R.string.female)) {
            Glide.with(this)
                .load(R.drawable.ic_girl)
                .into(binding.ivAvatarCheckup)
        } else {
            Glide.with(this)
                .load(R.drawable.ic_boy)
                .into(binding.ivAvatarCheckup)
        }
    }

    private fun suggestionSetup() {
        val kidsResult = intent.getStringExtra(SelectActivity.EXTRA_RESULT)

        binding.tvSuggestionResult.text = when (kidsResult) {
            "Karies" -> getString(R.string.suggestion_karies)
            "Berlubang" -> getString(R.string.suggestion_berlubang)
            "Sehat" -> getString(R.string.suggestion_sehat)
            else -> "Tidak ada rekomendasi"
        }

    }

    private fun setupBottomBar() {
        val bottomBar = binding.bottomBar
        bottomBar.selectedItemId = R.id.navigation_checkup
        bottomBar.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this@CheckUpResultActivity, HomePageActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_checkup -> {
                    startActivity(Intent(this@CheckUpResultActivity, AddKidsDataActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_nearest_dentist -> {
                    startActivity(Intent(this@CheckUpResultActivity, NearestDentistActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    startActivity(Intent(this@CheckUpResultActivity, ProfileActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    private fun navigateActivity(targetActivity: Class<*>) {
        val intent = Intent(this@CheckUpResultActivity, targetActivity)
        startActivity(intent)
    }



}