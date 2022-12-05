package com.example.saytahminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_game_screen.*
import kotlin.random.Random

class GameScreenActivity : AppCompatActivity() {
    private var randomNumber =0
    private var remainingTrial=5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        randomNumber = Random.nextInt(21)
        Log.e("Lucky Number: " ,randomNumber.toString())


        buttonGuess.setOnClickListener {
            remainingTrial--
            val enteredNumber = editTextNumber.text.toString().toInt()
            if (remainingTrial==0){
                val newIntent = Intent(this@GameScreenActivity,ResultActivity::class.java)
                newIntent.putExtra("result","INCORRECT!")
                newIntent.putExtra("face","game_lose")
                finish()
                startActivity(newIntent)
                return@setOnClickListener
            }
            if (enteredNumber<randomNumber){
                textViewHigherOrLower.text = "Try Higher"
                textViewRemainingTrial.text = "Remaining Trial: $remainingTrial"
            }
            if (enteredNumber>randomNumber){
                textViewHigherOrLower.text ="Try Lower"
                textViewRemainingTrial.text = "Remaining Trial: $remainingTrial"
            }
            if(enteredNumber==randomNumber){
                val newIntent = Intent(this@GameScreenActivity,ResultActivity::class.java)
                newIntent.putExtra("result","CORRECT!")
                newIntent.putExtra("face","game_win")
                finish()
                startActivity(newIntent)
            }
            editTextNumber.setText("")




        }
    }
}