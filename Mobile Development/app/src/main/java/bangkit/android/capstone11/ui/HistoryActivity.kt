package bangkit.android.capstone11.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bangkit.android.capstone11.R
import bangkit.android.capstone11.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //btnBack
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@HistoryActivity, KidsDataActivity::class.java))
        }

        //bottomBar
        val bottomBar = binding.bottomBar
        bottomBar.selectedItemId = R.id.navigation_checkup
        bottomBar.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this@HistoryActivity, MainActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_checkup -> {
                    startActivity(Intent(this@HistoryActivity, KidsListActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_nearest_dentist -> {
                    startActivity(Intent(this@HistoryActivity, NearestDentistActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    //intent ke profile
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }

        //btnNearestDentist
        binding.btnNearestDentist.setOnClickListener {
            startActivity(Intent(this@HistoryActivity, NearestDentistActivity::class.java))
        }
    }
}