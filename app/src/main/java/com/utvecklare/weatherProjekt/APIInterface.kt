package com.utvecklare.weatherProjekt

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    // Get endpoint

    @GET ("data/2.5/weather?")

    fun getData(@Query("q") CityName: String,
                @Query("APPID") APIKey: String,
               ):
            Call<MyWeatherData>

}