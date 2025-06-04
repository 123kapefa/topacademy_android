package com.example.topacademy_android.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.topacademy_android.R
import com.example.topacademy_android.calculator.presentation.CalculatorActivity
import com.example.topacademy_android.carList.presentation.CarListActivity
import com.example.topacademy_android.weather.presentation.WeatherActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.btnCalc).setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }

        findViewById<Button>(R.id.btnList).setOnClickListener {
            startActivity(Intent(this, CarListActivity::class.java))
        }

        findViewById<Button>(R.id.btnWeather).setOnClickListener {
            startActivity(Intent(this, WeatherActivity::class.java))
        }
    }
}
