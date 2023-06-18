package com.example.uts.activites

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide
import com.example.uts.Domain.ItemsDomain
import com.example.uts.R

class DetailActivity : AppCompatActivity() {
    private lateinit var dateTxt: TextView
    private lateinit var tittleTxt: TextView
    private lateinit var durationTxt: TextView
    private lateinit var rateTxt: TextView
    private lateinit var descriptionTxt: TextView
    private lateinit var pic: ImageView
    private lateinit var item: ItemsDomain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
        setVariable()

        val button: AppCompatButton = findViewById(R.id.button)
        button.setOnClickListener {
            val youtubeUrl = getYoutubeUrl(item.tittle) // Mendapatkan URL YouTube sesuai dengan judul item
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
            startActivity(intent)
        }
    }

    private fun getYoutubeUrl(tittle: String): String {
        val videoIdMap = hashMapOf(
            "Fast X" to "https://youtu.be/eoOaKN4qCKw",
            "Transformers: Rise of the Beasts" to "https://youtu.be/itnqEauWQZM",
            "Sang Pencerah" to "https://youtu.be/hXz16kfZhRw",
            "Pengabdi Setan" to "https://youtu.be/0hSptYxWB3E",
            "Comic 8" to "https://youtu.be/3DSldkw35n4",
            "The Last : Naruto The Movie" to "The Last : Naruto The Movie",
            "One Piece Film Red" to "https://www.youtube.com/watch?v=89JWRYEIG-s",
            "Demon Slayer The Movie" to "https://www.youtube.com/watch?v=bFwdl2PDAFM&t=1s",
            "Doraemon Stand By Me 2" to "https://www.youtube.com/watch?v=oiCwcpB837A",
            "https://www.youtube.com/watch?v=FHgm89hKpXU" to "https://www.youtube.com/watch?v=FHgm89hKpXU"
        )

        val videoId = videoIdMap[tittle] ?: ""
        return "https://www.youtube.com/watch?v=$videoId"
    }

    private fun setVariable() {
        item = intent.getSerializableExtra("object") as ItemsDomain

        dateTxt.text = item.date
        tittleTxt.text = item.tittle
        durationTxt.text = item.duration
        rateTxt.text = item.rate.toString()
        descriptionTxt.text = item.description

        val drawableResource = resources.getIdentifier(item.pic, "drawable", packageName)
        Glide.with(this).load(drawableResource).into(pic)
    }

    private fun initView() {
        dateTxt = findViewById(R.id.dateTxt)
        tittleTxt = findViewById(R.id.tittleTxt)
        durationTxt = findViewById(R.id.durationTxt)
        rateTxt = findViewById(R.id.rateTxt)
        descriptionTxt = findViewById(R.id.descriptionTxt)
        pic = findViewById(R.id.pic)
    }
}
