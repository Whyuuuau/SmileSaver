package bangkit.android.capstone11.ui


import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import bangkit.android.capstone11.databinding.ActivityHomePageBinding
import bangkit.android.capstone11.R
import bangkit.android.capstone11.ui.preferences.UserManager
import bangkit.android.capstone11.ui.view_model.ViewModelFactory
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    private lateinit var preferences: UserManager
    private lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomBar()

        //inisialisasi image slide
        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        val slideModels = ArrayList<SlideModel>().apply {
            add(SlideModel(R.drawable.slider1, ScaleTypes.FIT))
            add(SlideModel(R.drawable.slider2, ScaleTypes.FIT))
            add(SlideModel(R.drawable.slider3, ScaleTypes.FIT))
        }
        imageSlider.setImageList(slideModels, ScaleTypes.FIT)
        setupView()
        setupProperty()
        homeSetup()

        //btnCheckUp
        val btnCheckUp = binding.btnStartCheckup
        btnCheckUp.setOnClickListener {
            startActivity(Intent(this@HomePageActivity, AddKidsDataActivity::class.java))
        }

        //card news
        var cardNo = 0
        val cardNews1 = binding.news1
        cardNews1.setOnClickListener {
            cardNo = 1
            cardNewsAction(cardNo)
        }
        val cardNews2 = binding.news2
        cardNews2.setOnClickListener {
            cardNo = 2
            cardNewsAction(cardNo)
        }
        val cardNews3 = binding.news3
        cardNews3.setOnClickListener {
            cardNo = 3
            cardNewsAction(cardNo)
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

    private fun homeSetup(){
        binding.avaEmailUser.text = preferences.getEmail()
        binding.avaUser.text = preferences.getUsername()
    }

    private fun cardNewsAction(noCard: Int) {
        Intent(this@HomePageActivity, NewsActivity::class.java).apply{
            putExtra(HomePageActivity.EXTRA_NEWS, noCard)
            startActivity(this)
        }
    }

    private fun setupProperty(){
        factory = ViewModelFactory.getInstance(this)
        preferences = UserManager(this)
    }

    private fun setupBottomBar() {
        val bottomBar = binding.bottomBar
        bottomBar.selectedItemId = R.id.navigation_home
        bottomBar.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    return@setOnNavigationItemSelectedListener false
                }
                R.id.navigation_checkup -> {
                    startActivity(Intent(this@HomePageActivity, AddKidsDataActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_nearest_dentist -> {
                    startActivity(Intent(this@HomePageActivity, NearestDentistActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    startActivity(Intent(this@HomePageActivity, ProfileActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    companion object {
        const val EXTRA_NEWS = "extra_news"
    }
}