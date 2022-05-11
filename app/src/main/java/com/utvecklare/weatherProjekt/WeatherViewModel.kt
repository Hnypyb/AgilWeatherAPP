package com.utvecklare.weatherProjekt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson

class WeatherViewModel : ViewModel(){
    var MyWeatherData = MutableLiveData<MyWeatherData>()

    fun getMyWeatherData(CityName: String) {

        // Making Request
        val responseString =
            Fuel.get("https:\\api.openweathermap.org/data/2.5/weather?q=${CityName}&APPID=64d49bf732ac67e9decaf745c8a3a586\n")
                .responseString { request, response, result ->
                    try {
                        val gson = Gson()
                        val resp = gson.fromJson(CityName, MyWeatherData::class.java)
                        MyWeatherData.value
                    } catch (ex: Exception) {

                    }
                }

    }

}
