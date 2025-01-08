package com.example.tips_calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tips_calculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        //enableEdgeToEdge()
        setContentView(binding.root)

        var porcentagem: Int = 0

        binding.rbOpOUm.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                porcentagem = 10
            }
        }

        binding.rbOpODois.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                porcentagem = 15
            }
        }

        binding.rbOpOTrS.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                porcentagem = 20
            }
        }

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.num_people,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.spinnerNumPessoas.adapter = adapter


        var numOfPeopleSelected = 0
        binding.spinnerNumPessoas.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    numOfPeopleSelected = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }

        binding.btnCalcular.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text.toString()


            if (totalTableTemp?.isEmpty() == true
            ) {

                Snackbar.make(binding.tieTotal, "Preencha Todos Os Campos", Snackbar.LENGTH_LONG)
                    .show()

            } else {
                val totalTable: Float = binding.tieTotal.text.toString().toFloat()
                val nPeople: Int = numOfPeopleSelected + 1

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * porcentagem / 100
                val totalWithTips = totalTemp + tips

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("numPeople", numOfPeopleSelected)
                    putExtra("percentage", porcentagem)
                    putExtra("totalAmount", totalWithTips)
                }
                startActivity(intent)

            }

        }

        binding.btnLimpar.setOnClickListener {
            binding.tieTotal.setText("")
            binding.rbOpOUm.isChecked = false
            binding.rbOpODois.isChecked = false
            binding.rbOpOTrS.isChecked = false


        }

    }
}