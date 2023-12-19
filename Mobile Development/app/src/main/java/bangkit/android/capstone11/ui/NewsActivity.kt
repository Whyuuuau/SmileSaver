package bangkit.android.capstone11.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bangkit.android.capstone11.R
import bangkit.android.capstone11.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val noNews = intent.getIntExtra(EXTRA_NEWS, 0)

        val imageNews = binding.ivNewsImage
        val nameNews = binding.tvNewsName
        val containNews = binding.tvNewsContain
        val btnBack = binding.btnBack

        when (noNews) {
            1 -> {
                imageNews.setImageResource(R.drawable.berita1)
                nameNews.setText(R.string.news1_title)
                containNews.setText(R.string.news1)
            }
            2 -> {
                imageNews.setImageResource(R.drawable.berita2)
                nameNews.setText(R.string.news2_title)
                containNews.setText(R.string.news2)
            }
            3 -> {
                imageNews.setImageResource(R.drawable.berita3)
                nameNews.setText(R.string.news3_title)
                containNews.setText(R.string.news3)
            }
        }

        btnBack.setOnClickListener {
            startActivity(Intent(this@NewsActivity, HomePageActivity::class.java))
        }
    }

    companion object {
        private const val EXTRA_NEWS = "extra_news"
    }
}