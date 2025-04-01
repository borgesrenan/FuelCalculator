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

class ConsumptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumption)

        //Here I got fuel value from previous activity
        val fuelValue = intent.getFloatExtra("FUEL_VALUE", 0f)

        val edtConsump = findViewById<TextInputEditText>(R.id.edt_consump)
        val btnNext = findViewById<Button>(R.id.btn_next)

        btnNext.setOnClickListener {

            //Checking if its null, field is required
            val consumpText = edtConsump.text?.toString() ?: ""

            if (consumpText.isBlank()) {
                Snackbar.make(edtConsump, "This field is required.", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val consump: Float = edtConsump.text.toString().toFloat()
            val intent = Intent(this, DistanceActivity::class.java)

            //Sending values from this activity and from fuel activity to Distance Activity
            intent.putExtra("CONSUMPTION_VALUE", consump)
            intent.putExtra("FUEL_VALUE", fuelValue)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}