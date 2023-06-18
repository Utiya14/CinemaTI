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
            "Fast X" to "eoOaKN4qCKw",
            "Transformers: Rise of the Beasts" to "itnqEauWQZM",
            "Sang Pencerah" to "hXz16kfZhRw",
            "Pengabdi Setan" to "0hSptYxWB3E",
            "Comic 8" to "3DSldkw35n4",
            "The Last : Naruto The Movie" to "tA3yE4_t6SY",
            "One Piece Film Red" to "89JWRYEIG-s",
            "Demon Slayer The Movie" to "bFwdl2PDAFM",
            "Doraemon Stand By Me 2" to "oiCwcpB837A",
            "Dragon Ball Super: Broly" to "FHgm89hKpXU"
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
