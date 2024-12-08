package io.github.felipeecp.rideapp.data.dto.request

data class RideConfirmRequest(
    val customer_id: String,
    val origin: String,
    val destination: String,
    val distance: Double,
    val duration: String,
    val driver: DriverRequest,
    val value: Double
)