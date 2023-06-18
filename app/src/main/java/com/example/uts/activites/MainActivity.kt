package com.example.uts.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.Adapter.ItemsAdapter
import com.example.uts.Domain.ItemsDomain
import com.example.uts.R

class MainActivity : AppCompatActivity() {
    private lateinit var adapterPopuler: ItemsAdapter
    private lateinit var recyclerViewPopuler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    fun openMainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun openMainActivity2(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    private fun initRecyclerView() {
        val itemsArrayList = ArrayList<ItemsDomain>()

        itemsArrayList.add(
            ItemsDomain(
                "Aksi",
                "17 Mei 2023",
                "Fast X",
                "Musuh dari masa lalu kini menghampiri Dom (Vin Diesel) dan keluarganya.\n" +
                        "Dante (Jason Momoa) putra gembong narkoba Hernan Reyes (Joaquim de Almeida)\n" +
                        "yang dihancurkan Dom dan kelompoknya di seri kelima kini datang\n" +
                        "dan berusaha balas dendam atas kematian sang ayah.",
                "fastx",
                "2 Jam 21 menit",
                13
            )
        )
        itemsArrayList.add(
            ItemsDomain(
                "Aksi", "9 Juni 2023", "Transformers: Rise of the Beasts",
                "Optimus Prime pertama kali bertemu dengan Optimus Primal yang berbentuk\n" +
                        "Gorila, mereka harus bersatu untuk menghadapi ancaman dari Transformer Unicorn.\n" +
                        "Disaat yang bersamaan mereka akan melawan Terrocon yang dipemimpin oleh \n" +
                        "Scourge", "transformer", "2 Jam 7 menit", 13
            )
        )
        itemsArrayList.add(
            ItemsDomain(
                "Drama", "8 September 2010", "Sang Pencerah",
                "Seorang pemuda usia 21 tahun yang gelisah atas pelaksanaan syariat Islam\n" +
                        "yang melenceng ke arah sesat, Syirik dan Bid'ah. Dengan sebuah kompas,\n" +
                        "dia menunjukkan arah kiblat di Masjid Besar Kauman yang selama ini diyakini\n" +
                        "ke barat ternyata bukan menghadap ke Ka'bah di Mekah,\n" +
                        "melainkan ke Afrika", "sangpencerah", "1 Jam 52 menit", 13
            )
        )
        itemsArrayList.add(
            ItemsDomain(
                "Horor", "28 September 2017", "Pengabdi Setan",
                "Sebuah keluarga yang terdiri dari ayah, ibu, nenek, dan 4 orang anak\n" +
                        "yang harus mengalami kejadian mistis semenjak ibu mereka meninggal.\n" +
                        "Tak disangka ternyata ada keterlibatan kelompok ajar sesat\n" +
                        "yang bersekutu dengan ibu mereka semasa hidup", "pengabdisetan", "1 Jam 47 menit", 13
            )
        )
        itemsArrayList.add(
            ItemsDomain(
                "Komedi", "29 Januari 2014", "Comic 8",
                "Para komika yang ingin melakukan perampokan di Bank INI malah harus bersatu\n" +
                        "agar bisa lari dari kejaran polisi, namun dibalik semua itu ternyata ada\n" +
                        "dalang yang menggerakan para komika untuk melakukan aksi perampokan\n"
                        , "comic8", "1 Jam 30 menit", 17
            )
        )

        recyclerViewPopuler = findViewById(R.id.viewPopuler)
        recyclerViewPopuler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapterPopuler = ItemsAdapter(itemsArrayList)

        recyclerViewPopuler.adapter = adapterPopuler
    }
}
