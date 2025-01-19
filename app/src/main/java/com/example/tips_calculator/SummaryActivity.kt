package com.example.tips_calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tips_calculator.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(this.layoutInflater)
        setContentView(binding.root)


        val totalTable = intent.getFloatExtra("totalTable", 0F)
        val numPeople = intent.getIntExtra("numPeople", 0) // Key corrigida
        val percentage = intent.getIntExtra("percentage", 0) // Key corrigida
        val totalAmount = intent.getFloatExtra("totalAmount", 0F) // Key corrigida


        binding.tvPercentage.text = "$percentage%"
        binding.tvTotalAmount.text = String.format("%.2f", totalAmount)
        binding.tvNumPeopleTable.text = numPeople.toString()
        binding.tvTotalTable.text = String.format("%.2f", totalTable)


        binding.btnDone.setOnClickListener {
            finish()
        }
    }
}
