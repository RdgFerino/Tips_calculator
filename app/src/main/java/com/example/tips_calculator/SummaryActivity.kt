package com.example.tips_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_summary)

        val totalTable = intent.getFloatExtra("totalTable", 0F)
        val numPeople = intent.getIntExtra("numOfPeopleSelected", 0)
        val percentage = intent.getIntExtra("porcentagem", 0)
        val totalAmount = intent.getFloatExtra("totalWithtips", 0F)

        println("Raoni1" + totalAmount)
    }
}