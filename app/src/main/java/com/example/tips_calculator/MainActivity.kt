package com.example.tips_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tips_calculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        var porcentagem: Int = 0

        binding.rbOpOUm.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                porcentagem = 10
            }
        }

        binding.rbOpODois.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                porcentagem = 15
            }
        }

        binding.rbOpOTrS.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                porcentagem = 20
            }
        }




       binding.btnLimpar.setOnClickListener {
           println("Raoni1" + binding.tieTotal.text)
           println("Raoni1" + binding.tieNumPessoas.text)
       }

        binding.btnCalcular.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val nPeopleTemp = binding.tieNumPessoas.text

            if (totalTableTemp?.isEmpty() == true ||
                nPeopleTemp?.isEmpty() == true){

                Snackbar.make(binding.tieTotal, "Preencha Todos Os Campos", Snackbar.LENGTH_LONG).show()

            } else {
                val totalTable: Float = binding.tieTotal.text.toString().toFloat()
                val nPeople: Int = binding.tieNumPessoas.text.toString().toInt()

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * porcentagem / 100
                val totalWithtips = totalTemp + tips
                binding.tvResult.text = "Total With Tips: $totalWithtips"

            }

        }

        binding.btnLimpar.setOnClickListener {
            binding.tvResult.text = ""
            binding.tieTotal.setText("")
            binding.tieNumPessoas.setText("")
            binding.rbOpOUm.isChecked = false
            binding.rbOpODois.isChecked = false
            binding.rbOpOTrS.isChecked = false
        }

    }
}