package com.example.saytahminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultView = intent.getStringExtra("face")
        val resultText = intent.getStringExtra("result")
        imageView.setImageResource(resources.getIdentifier(resultView,"drawable",packageName))
        textViewResult.text=resultText
        buttonTryAgain.setOnClickListener {
            finish()
            startActivity(Intent(this@ResultActivity,GameScreenActivity::class.java))
        }

    }
}