package io.github.felipeecp.rideapp.data.dto.response

data class DriverOptionResponse(
    val id: Int,
    val name: String,
    val description: String,
    val vehicle: String,
    val review: ReviewResponse,
    val value: Double,
)
