package com.example.assignment_4

import com.google.gson.annotations.SerializedName

data class StandingsTable(

	@field:SerializedName("StandingsLists")
	val standingsLists: List<StandingsListsItem?>? = null,

	@field:SerializedName("season")
	val season: String? = null
)

data class DriverStandingsItem(

	@field:SerializedName("wins")
	val wins: String? = null,

	@field:SerializedName("positionText")
	val positionText: String? = null,

	@field:SerializedName("Driver")
	val driver: Driver? = null,

	@field:SerializedName("Constructors")
	val constructors: List<ConstructorsItem?>? = null,

	@field:SerializedName("position")
	val position: String? = null,

	@field:SerializedName("points")
	val points: String? = null
)

data class ConstructorsItem(

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("constructorId")
	val constructorId: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Driver(

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

data class StandingsListsItem(

	@field:SerializedName("round")
	val round: String? = null,

	@field:SerializedName("DriverStandings")
	val driverStandings: List<DriverStandingsItem?>? = null,

	@field:SerializedName("season")
	val season: String? = null
)
