package io.github.felipeecp.rideapp.domain.model

data class RideEstimate(
    val origin: Location,
    val destination: Location,
    val distance: Double,
    val duration: String,
    val driverOptions: List<DriverOption>,
    val routeData: Any
)
