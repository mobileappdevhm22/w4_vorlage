package com.example.assignment_4.constants

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceModule {
    // Retrofit
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .baseUrl("https://ergast.com/api/f1/")
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}