package com.example.assignment_4.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_4.DriverStandingsItem
import com.example.assignment_4.model.DriversAPI
import com.example.assignment_4.DriversItem
import com.example.assignment_4.constants.ServiceModule
import kotlinx.coroutines.launch

class DriversViewModel : ViewModel() {
    private val _driversList = mutableStateListOf<DriversItem?>()
    private val _driversStandingList = mutableStateListOf<DriverStandingsItem?>()
    var errorMessage: String by mutableStateOf("")

    val driversList: List<DriversItem?>
        get() = _driversList
    val driversStandingList: List<DriverStandingsItem?>
        get() = _driversStandingList

    fun getDrivers() {
        viewModelScope.launch {
            val apiService = ServiceModule.buildService(DriversAPI::class.java).getDrivers(2022)
            try {
                _driversList.clear()
                _driversList.addAll(apiService.mRData?.driverTable?.drivers!!)

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getDriversStanding() {
        viewModelScope.launch {
            val apiService = ServiceModule.buildService(DriversAPI::class.java).getDriversStanding(2022)
            try {
                _driversStandingList.clear()
                _driversStandingList.addAll(apiService.mRData?.standingsTable?.standingsLists?.get(0)?.driverStandings!!)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}