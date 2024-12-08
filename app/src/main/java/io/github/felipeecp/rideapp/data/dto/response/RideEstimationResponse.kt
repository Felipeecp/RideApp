package io.github.felipeecp.rideapp.data.dto.response

data class RideEstimationResponse(
    val origin: LocationResponse,
    val destination: LocationResponse,
    val distance: Double,
    val duration: String,
    val options: List<DriverOptionResponse>,
    val routeResponse: Any
)
