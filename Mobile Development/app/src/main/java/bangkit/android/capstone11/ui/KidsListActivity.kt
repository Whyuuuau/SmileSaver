package bangkit.android.capstone11.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bangkit.android.capstone11.R
import bangkit.android.capstone11.data.data_local.DummyKidsData
import bangkit.android.capstone11.databinding.ActivityKidsListBinding
import bangkit.android.capstone11.ui.adapter.KidsListAdapter

class KidsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKidsListBinding
    private lateinit var rvKidsList: RecyclerView
    private val dummyKidsData = DummyKidsData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKidsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //btnBack
        binding.btnBack.setOnClickListener {navigateActivity(HomePageActivity::class.java)}

        //btnCheckUp
        binding.btnNewCheckup.setOnClickListener {navigateActivity(AddKidsDataActivity::class.java)}

        //bottomBar
        setupBottomBar()

        //recyclerView
        rvKidsList = binding.rvHistoryList
        if (dummyKidsData.name == null) {
            rvKidsList.visibility = View.INVISIBLE
        } else {
            rvKidsList.visibility = View.VISIBLE
        }
        showHistoryList()

    }

    private fun showHistoryList() {
        rvKidsList.layoutManager = LinearLayoutManager(this)
        val adapter = KidsListAdapter(dummyKidsData)
        rvKidsList.adapter = adapter
    }

    private fun navigateActivity(targetActivity: Class<*>) {
        startActivity(Intent(this@KidsListActivity, targetActivity))
    }

    private fun setupBottomBar() {
        val bottomBar = binding.bottomBar
        bottomBar.selectedItemId = R.id.navigation_checkup
        bottomBar.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this@KidsListActivity, HomePageActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_checkup -> {
                    return@setOnNavigationItemSelectedListener false
                }
                R.id.navigation_nearest_dentist -> {
                    startActivity(Intent(this@KidsListActivity, NearestDentistActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    //intent ke profile
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

}