package com.example.assignment_4.model

import com.example.assignment_4.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DriversAPI {

    @GET("{year}/drivers.json")
    suspend fun getDrivers(
        @Path("year") year: Int
    ): Response

    @GET("{year}/driverStandings.json")
    suspend fun getDriversStanding(
        @Path("year") year: Int
    ): Response
}