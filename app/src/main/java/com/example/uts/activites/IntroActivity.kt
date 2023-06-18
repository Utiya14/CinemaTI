package com.example.uts.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.uts.R

class IntroActivity : AppCompatActivity() {
    private lateinit var startBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

    initView();
    }

    private fun initView(){
        startBtn = findViewById(R.id.startBtn)
        startBtn.setOnClickListener {
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        }

       /* secondBtn = findViewById(R.id.secondBtn)
        secondBtn.setOnClickListener {
            startActivity(Intent(this@IntroActivity, SecondActivity::class.java))
        }*/
    }

}