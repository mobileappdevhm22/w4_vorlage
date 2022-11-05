package com.example.assignment_4

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("MRData")
	val mRData: MRData? = null
)

data class DriverTable(

	@field:SerializedName("Drivers")
	val drivers: List<DriversItem?>? = null,

	@field:SerializedName("season")
	val season: String? = null
)

data class DriversItem(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("driverId")
	val driverId: String? = null,

	@field:SerializedName("permanentNumber")
	val permanentNumber: String? = null,

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("givenName")
	val givenName: String? = null,

	@field:SerializedName("familyName")
	val familyName: String? = null,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class MRData(

	@field:SerializedName("xmlns")
	val xmlns: String? = null,

	@field:SerializedName("total")
	val total: String? = null,

	@field:SerializedName("offset")
	val offset: String? = null,

	@field:SerializedName("series")
	val series: String? = null,

	@field:SerializedName("limit")
	val limit: String? = null,

	@field:SerializedName("DriverTable")
	val driverTable: DriverTable? = null,

	@field:SerializedName("StandingsTable")
	val standingsTable: StandingsTable? = null,

	@field:SerializedName("url")
	val url: String? = null
)
