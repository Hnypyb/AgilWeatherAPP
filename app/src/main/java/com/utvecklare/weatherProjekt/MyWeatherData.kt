package com.utvecklare.weatherProjekt


import com.google.gson.annotations.SerializedName

data class MyWeatherData(
    @SerializedName("base")
    val base: String, // stations
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("cod")
    val cod: Int, // 200
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("dt")
    val dt: Int, // 1652105612
    @SerializedName("id")
    val id: Int, // 2643743
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val name: String, // London
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("timezone")
    val timezone: Int, // 3600
    @SerializedName("visibility")
    val visibility: Int, // 10000
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
) {
    data class Clouds(
        @SerializedName("all")
        val all: Int // 100
    )

    data class Coord(
        @SerializedName("lat")
        val lat: Double, // 51.5085
        @SerializedName("lon")
        val lon: Double // -0.1257
    )

    data class Main(
        @SerializedName("feels_like")
        val feelsLike: Double, // 294.12
        @SerializedName("humidity")
        val humidity: Int, // 53
        @SerializedName("pressure")
        val pressure: Int, // 1022
        @SerializedName("temp")
        val temp: Double, // 294.54
        @SerializedName("temp_max")
        val tempMax: Double, // 295.51
        @SerializedName("temp_min")
        val tempMin: Double // 293.02
    )

    data class Sys(
        @SerializedName("country")
        val country: String, // GB
        @SerializedName("id")
        val id: Int, // 2019646
        @SerializedName("sunrise")
        val sunrise: Int, // 1652069901
        @SerializedName("sunset")
        val sunset: Int, // 1652124935
        @SerializedName("type")
        val type: Int // 2
    )

    data class Weather(
        @SerializedName("description")
        val description: String, // overcast clouds
        @SerializedName("icon")
        val icon: String, // 04d
        @SerializedName("id")
        val id: Int, // 804
        @SerializedName("main")
        val main: String // Clouds
    )

    data class Wind(
        @SerializedName("deg")
        val deg: Int, // 200
        @SerializedName("speed")
        val speed: Double // 6.17
    )
}