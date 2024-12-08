package io.github.felipeecp.rideapp.domain.usecase

import io.github.felipeecp.rideapp.domain.exceptions.DomainException
import io.github.felipeecp.rideapp.domain.model.Ride
import io.github.felipeecp.rideapp.domain.repository.RideRepository
import javax.inject.Inject

class GetRideHistoryUseCase @Inject constructor(
    private val rideRepository: RideRepository
){
    suspend operator fun invoke(
        customerId: String,
        driverId: Int? = null
    ): Result<List<Ride>> {
        if(customerId.isBlank()){
            return Result.failure(DomainException.InvalidCustomerIdException()))
        }

        return rideRepository.getRideHistory(customerId, driverId)
    }
}