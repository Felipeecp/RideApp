package io.github.felipeecp.rideapp.data.dto.request

data class RideEstimateRequest(
    val customer_id: String,
    val origin: String,
    val destination: String
)
