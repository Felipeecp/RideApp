package io.github.felipeecp.rideapp.domain.usecase

import io.github.felipeecp.rideapp.domain.exceptions.DomainException
import io.github.felipeecp.rideapp.domain.model.RideEstimate
import io.github.felipeecp.rideapp.domain.repository.RideRepository
import javax.inject.Inject

class EstiateRideUseCase @Inject constructor(
    private val rideRepository: RideRepository
) {
    suspend operator fun invoke(
        customerId: String,
        origin: String,
        destination: String
    ): Result<RideEstimate>{
        if(customerId.isBlank()){
            return Result.failure(DomainException.InvalidCustomerIdException())
        }
        if(origin.isBlank()){
            return Result.failure(DomainException.InvalidOriginException())
        }
        if(destination.isBlank()){
            return Result.failure(DomainException.InvalidDestinationException())
        }
        if(origin == destination){
            return Result.failure(DomainException.SameLocationException())
        }
        return rideRepository.estimeRide(customerId, origin, destination)
    }
}