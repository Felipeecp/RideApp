package io.github.felipeecp.rideapp.data.mapper

import io.github.felipeecp.rideapp.data.dto.response.DriverResponse
import io.github.felipeecp.rideapp.data.dto.response.RideResponse
import io.github.felipeecp.rideapp.domain.model.Driver
import io.github.felipeecp.rideapp.domain.model.Ride
import javax.inject.Inject

class RideHistoryMapper @Inject constructor(): BaseMapper<RideResponse, Ride> {
    override fun fromDomain(domain: Ride): RideResponse {
        return RideResponse(
            id = domain.id,
            date = domain.date,
            origin = domain.origin,
            destination = domain.destination,
            distance = domain.distance,
            duration = domain.duration,
            driver = DriverResponse(
                id = domain.driver.id,
                name = domain.driver.name
            ),
            value = domain.value
        )
    }

    override fun toDomain(entity: RideResponse): Ride {
        return Ride(
            id = entity.id,
            date = entity.date,
            origin = entity.origin,
            destination = entity.destination,
            distance = entity.distance,
            duration = entity.duration,
            driver = Driver(
                id = entity.driver.id,
                name = entity.driver.name
            ),
            value = entity.value
        )
    }
}