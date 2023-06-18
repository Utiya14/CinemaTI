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

class MainActivity2 : AppCompatActivity() {
    private lateinit var adapterPopuler: ItemsAdapter
    private lateinit var recyclerViewPopuler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

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
                "Aksi/Petualangan",
                "6 Desember 2014",
                "The Last : Naruto The Movie",
                "Dua tahun setelah Perang Dunia Shinobi Keempat,\n" +
                        "Naruto harus menghentikan Toneri Otsutsuki, keturunan\n" +
                        "Hamura Otsutsuki, setelah Toneri menyebabkan bulan turun\n" +
                        "ke Bumi.\n",
                "narutothe",
                "1 Jam 52 menit",
                8
            )
        )
        itemsArrayList.add(
            ItemsDomain(
                "Aksi/Petualangan", "21 September 2022", "One Piece Film Red",
                "Uta adalah penyanyi yang dicintai, terkenal karena\n" +
                        "menyembunyikan identitasnya sendiri saat tampil. Suaranya\n" +
                        "digambarkan sebagai \"dunia lain\". Kini, untuk pertama kalinya,\n" +
                        "Uta akan mengungkapkan dirinya kepada dunia dalam sebuah konser live.\n",
                        "onepiece", "1 Jam 55 menit", 7
            )
        )
        itemsArrayList.add(
            ItemsDomain(
                "Aksi/Fantasi", "6 Januari 2021", "Demon Slayer The Movie",
                "Seorang anak laki-laki yang dibesarkan oleh babi hutan,\n" +
                        "yang memakai kepala babi hutan, menaiki Kereta Infinity\n" +
                        "dalam misi baru dengan Pilar Api bersama dengan anak laki-laki\n" +
                        "lain yang mengungkapkan kekuatan aslinya saat dia tidur.\n" +
                        "Misi mereka adalah mengalahkan iblis yang telah menyiksa orang\n" +
                        "dan membunuh para pembunuh iblis yang menentangnya.\n"
                , "demonslayer", "1 Jam 57 menit", 8
            )
        )
        itemsArrayList.add(
            ItemsDomain(
                "Petualangan/Sains Fiksi", "18 Desember 2014", "Doraemon Stand By Me 2",
                "Sewashi dan Doraemon kembali ke masa lalu dan\n" +
                        "bertemu Nobita. Terserah Doraemon untuk merawat\n" +
                        "Nobita atau dia tidak akan kembali ke masa sekarang.\n",
                        "doraemon", "1 Jam 34 menit", 7
            )
        )
        itemsArrayList.add(
            ItemsDomain(
                "Aksi/Fantasi", "16 Februari 2019", "Dragon Ball Super: Broly",
                "Bumi damai setelah Turnamen Kekuasaan tetapi Goku\n" +
                        "terus berlatih, mengetahui bahwa ada kekuatan yang\n" +
                        "lebih kuat di alam semesta. Dengan kedatangan prajurit\n" +
                        "Saiyan bernama Broly, Goku dan Vegeta menghadapi tantangan\n" +
                        "paling berbahaya.\n"
                , "dragonball", "1 Jam 40 menit", 8
            )
        )

        recyclerViewPopuler = findViewById(R.id.viewPopuler2)
        recyclerViewPopuler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapterPopuler = ItemsAdapter(itemsArrayList)

        recyclerViewPopuler.adapter = adapterPopuler
    }
}
