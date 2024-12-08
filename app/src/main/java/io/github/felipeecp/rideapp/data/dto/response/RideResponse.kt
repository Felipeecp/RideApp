package io.github.felipeecp.rideapp.data.dto.response

data class RideResponse(
    val id: Int,
    val date: String,
    val origin: String,
    val destination: String,
    val distance: Double,
    val duration: Int,
    val driver: DriverResponse,
    val value: Double
)
