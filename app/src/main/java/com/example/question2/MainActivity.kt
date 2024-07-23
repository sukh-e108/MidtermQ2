package com.example.question2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberInput: EditText = findViewById(R.id.numberInput)
        val unitSpinner: Spinner = findViewById(R.id.unitSpinner)
        val convertButton: Button = findViewById(R.id.convertButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        convertButton.setOnClickListener {
            val number = numberInput.text.toString().toDoubleOrNull()
            if (number != null) {
                val selectedUnit = unitSpinner.selectedItem.toString()
                val result = convertNumber(number, selectedUnit)
                resultTextView.text = result.toString()
            } else {
                resultTextView.text = "Error: Invalid input"
            }
        }
    }

    private fun convertNumber(number: Double, unit: String): Any {
        return when (unit) {
            "meters to kilometers" -> number / 1000
            "kilograms to grams" -> number * 1000
            else -> "Error: Invalid unit"
        }
    }
}
