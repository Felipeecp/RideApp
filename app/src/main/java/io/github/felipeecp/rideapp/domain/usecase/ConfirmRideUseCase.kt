package io.github.felipeecp.rideapp.domain.usecase

import io.github.felipeecp.rideapp.domain.exceptions.DomainException
import io.github.felipeecp.rideapp.domain.model.Driver
import io.github.felipeecp.rideapp.domain.repository.RideRepository
import javax.inject.Inject

class ConfirmRideUseCase @Inject constructor(
    private val rideRepository: RideRepository
) {
    suspend operator fun invoke(
        customerId: String,
        origin: String,
        destination: String,
        distance: Double,
        duration: String,
        driver: Driver,
        value: Double
    ): Result<Unit>{
        if(!isValidDistance(distance, driver.id)){
            return Result.failure(DomainException.InvalidDistanceException())
        }

        return rideRepository.confirmRide(
            customerId, origin, destination, distance, duration, driver, value
        )
    }

    private fun isValidDistance(distance: Double, driverId: Int): Boolean {
        val minimunDistance = when(driverId){
            1 -> 1.0
            2 -> 5.0
            3 -> 10.0
            else -> return false
        }
        return distance >= minimunDistance
    }
}