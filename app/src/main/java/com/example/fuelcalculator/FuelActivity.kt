package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class FuelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fuel)

        val edtFuel = findViewById<TextInputEditText>(R.id.edt_fuel)
        val btnNext = findViewById<Button>(R.id.btn_next)

        btnNext.setOnClickListener {

            //If its null, field is required
            val fuelText = edtFuel.text?.toString() ?: ""

            if (fuelText.isBlank()) {
                Snackbar.make(edtFuel, "This field is required.", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val fuel: Float = edtFuel.text.toString().toFloat()

            val intent = Intent(this, ConsumptionActivity::class.java)
            intent.putExtra("FUEL_VALUE", fuel)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}