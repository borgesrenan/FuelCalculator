package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResulActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resul)

        val fuelValue = intent.getFloatExtra("FUEL_VALUE", 0f)
        val consump = intent.getFloatExtra("CONSUMPTION_VALUE",0f)
        val distanceText = intent.getFloatExtra("DISTANCE_VALUE", 0f)
        val formattedCost = intent.getFloatExtra("TOTAL_VALUE", 0f)

        val txtResult = findViewById<TextView>(R.id.txt_result)
        val txtFuel = findViewById<TextView>(R.id.txt_price_review)
        val txtConsump = findViewById<TextView>(R.id.txt_consumo_review)
        val txtDistance = findViewById<TextView>(R.id.txt_km_review)

        txtResult.text = "€${String.format("%.2f", formattedCost)}"
        txtFuel.text = "€${String.format("%.2f", fuelValue)}"
        txtConsump.text = "${String.format("%.2f", consump)} KM/L"
        txtDistance.text = "${String.format("%.2f", distanceText)} KM"

        val btnNew = findViewById<Button>(R.id.btn_new)
        btnNew.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}