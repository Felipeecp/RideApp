package io.github.felipeecp.rideapp.data.dto.response

data class RideHistoryResponse(
    val customer_id: String,
    val rides: List<RideResponse>
)