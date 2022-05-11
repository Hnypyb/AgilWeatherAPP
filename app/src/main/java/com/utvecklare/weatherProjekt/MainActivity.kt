package com.utvecklare.weatherProjekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val textView = findViewById<TextView>(R.id.textView)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)

        var intentCityName = intent.getStringExtra("CityName")

        searchBtn.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }

        val q = intent.getStringExtra("CityName").toString()
        val APIKey = "64d49bf732ac67e9decaf745c8a3a586"

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(APIInterface::class.java)
        val call = service.getData(q, APIKey)
        call.enqueue(object : Callback<MyWeatherData>{
            override fun onResponse(call: Call<MyWeatherData>, response: Response<MyWeatherData>) {
               if (response.isSuccessful){
                   val MyWeatherData = response.body()!!
                   val stringBuilder = " Temp: ${MyWeatherData.main.temp.toInt()}"
                   val Coord = " Coord: ${MyWeatherData.coord.lat}"
                   val timezone = "timezone: ${MyWeatherData.timezone.toInt()}"

                   textView.text = stringBuilder
                   textView1.text = Coord
                   textView2.text = timezone

               }
            }

            override fun onFailure(call: Call<MyWeatherData>, t: Throwable) {
                textView.text = t.message
            }

        })



    }


}