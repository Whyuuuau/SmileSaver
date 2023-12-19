package bangkit.android.capstone11.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bangkit.android.capstone11.R
import bangkit.android.capstone11.data.data_local.NearestDentist
import bangkit.android.capstone11.databinding.ActivityNearestDentistBinding
import bangkit.android.capstone11.ui.adapter.NearestDentistAdapter

class NearestDentistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNearestDentistBinding
    private val listNearestDentist = ArrayList<NearestDentist>()
    private lateinit var rvNearestDentist: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNearestDentistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bottombar
        bottomBarSetup()

        //RecyclerView
        rvNearestDentist = binding.rvNearestDentist
        rvNearestDentist.setHasFixedSize(true)
        listNearestDentist.addAll(getListNearestDentist())
        showNearestDentistList()

    }

    private fun getListNearestDentist(): ArrayList<NearestDentist> {
        val dataName = resources.getStringArray(R.array.data_name_nearest_dentist)
        val dataAddress = resources.getStringArray(R.array.data_address_nearest_dentist)
        val dataImage = resources.obtainTypedArray(R.array.data_image_nearest_dentist)
        val list = ArrayList<NearestDentist>()
        for (i in dataName.indices) {
            val dentist = NearestDentist(dataImage.getResourceId(i, -1), dataName[i], dataAddress[i])
            list.add(dentist)
        }
        return list
    }

    private fun showNearestDentistList() {
        rvNearestDentist.layoutManager = LinearLayoutManager(this)
        val adapter = NearestDentistAdapter(listNearestDentist)
        rvNearestDentist.adapter = adapter
    }

    private fun bottomBarSetup() {
        val bottomBar = binding.bottomBar
        bottomBar.selectedItemId = R.id.navigation_nearest_dentist
        bottomBar.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this@NearestDentistActivity, HomePageActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_checkup -> {
                    startActivity(Intent(this@NearestDentistActivity, AddKidsDataActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_nearest_dentist -> {
                    return@setOnNavigationItemSelectedListener false
                }
                R.id.navigation_profile -> {
                    startActivity(Intent(this@NearestDentistActivity, ProfileActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

}