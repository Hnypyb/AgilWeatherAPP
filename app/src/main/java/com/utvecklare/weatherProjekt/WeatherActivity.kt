package com.utvecklare.weatherProjekt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class WeatherActivity : AppCompatActivity() {

   private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)



        val editText1 = findViewById<EditText>(R.id.editText1)
        val SearchBtn2 = findViewById<Button>(R.id.SearchBtn2)

        SearchBtn2.setOnClickListener{
            val CityName:String = editText1.text.toString()
            if(CityName.isNotEmpty()){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra ("CityName",CityName)
                startActivity(intent)
            }else{
                SearchBtn2.error = "Please Insert the City Name"
            }

        }
      weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        val CityName = findViewById<TextView>(R.id.CityName)
        val Description = findViewById<TextView>(R.id.Description)
        val Humidity = findViewById<TextView>(R.id. Humidity)
        val Wind = findViewById<TextView>(R.id.Wind)

        }

    }




