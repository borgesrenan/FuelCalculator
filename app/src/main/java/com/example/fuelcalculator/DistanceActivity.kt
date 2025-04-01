package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)

        val fuelValue = intent.getFloatExtra("FUEL_VALUE", 0f)
        val consump = intent.getFloatExtra("CONSUMPTION_VALUE",0f)

        val edtDistance = findViewById<TextInputEditText>(R.id.edt_distance)
        val btnCalc = findViewById<Button>(R.id.btn_calc)

        btnCalc.setOnClickListener {
            val distanceText: Float = edtDistance.text.toString().toFloat()


            // Calcula o custo total
            val totalCost = (distanceText / consump) * fuelValue


            println("Fuel => " + fuelValue)
            println("Consump => " + consump)
            println("Distance => " + distanceText)
            println("Result => " + totalCost)

            // Envia os dados para a tela de resultado
            val intent = Intent(this, ResulActivity::class.java)
            intent.putExtra("DISTANCE_VALUE", distanceText)
            intent.putExtra("CONSUMPTION_VALUE", consump)
            intent.putExtra("FUEL_VALUE", fuelValue)
            intent.putExtra("TOTAL_VALUE", totalCost)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}