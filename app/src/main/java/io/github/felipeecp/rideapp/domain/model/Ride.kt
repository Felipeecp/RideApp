package io.github.felipeecp.rideapp.domain.model

data class Ride(
    val id: Int,
    val date: String,
    val origin: String,
    val destination: String,
    val distance: Double,
    val duration: Int,
    val driver: Driver,
    val value: Double
)
