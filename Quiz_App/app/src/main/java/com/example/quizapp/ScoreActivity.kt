package com.example.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.score.setText("Congrates !!! Your Score is ${intent.getIntExtra("SCORE",0)}")

    }
}