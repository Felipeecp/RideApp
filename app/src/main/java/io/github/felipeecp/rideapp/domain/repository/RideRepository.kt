package io.github.felipeecp.rideapp.domain.repository

import io.github.felipeecp.rideapp.domain.model.Driver
import io.github.felipeecp.rideapp.domain.model.Ride
import io.github.felipeecp.rideapp.domain.model.RideEstimate

interface RideRepository {
    suspend fun estimeRide(
        customerId: String,
        origin: String,
        destination: String
    ): Result<RideEstimate>


    suspend fun confirmRide(
        customerId: String,
        origin: String,
        destination: String,
        distance: Double,
        duration: String,
        driver: Driver,
        value: Double
    ): Result<Unit>

    suspend fun getRideHistory(
        customerId: String,
        driverId: Int? = null
    ): Result<List<Ride>>

}