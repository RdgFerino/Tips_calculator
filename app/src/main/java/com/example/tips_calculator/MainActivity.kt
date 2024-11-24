package com.example.tips_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tips_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


       binding.btnLimpar.setOnClickListener {
           println("Raoni1" + binding.tieTotal.text)
           println("Raoni1" + binding.tieNumPessoas.text)
       }

    }
}