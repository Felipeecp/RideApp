package io.github.felipeecp.rideapp.data.mapper

import androidx.compose.foundation.LocalIndication
import io.github.felipeecp.rideapp.data.dto.response.DriverOptionResponse
import io.github.felipeecp.rideapp.data.dto.response.LocationResponse
import io.github.felipeecp.rideapp.data.dto.response.ReviewResponse
import io.github.felipeecp.rideapp.data.dto.response.RideEstimationResponse
import io.github.felipeecp.rideapp.domain.model.DriverOption
import io.github.felipeecp.rideapp.domain.model.Location
import io.github.felipeecp.rideapp.domain.model.Review
import io.github.felipeecp.rideapp.domain.model.RideEstimate
import javax.inject.Inject

class RideEstimateMapper @Inject constructor() : BaseMapper<RideEstimationResponse, RideEstimate> {
    override fun fromDomain(domain: RideEstimate): RideEstimationResponse {
        return RideEstimationResponse(
            origin = LocationResponse(
                latitude = domain.origin.latitude,
                longitude = domain.origin.longitude
            ),
            destination = LocationResponse(
                latitude = domain.destination.latitude,
                longitude = domain.destination.longitude
            ),
            distance = domain.distance,
            duration = domain.duration,
            options = domain.driverOptions.map { driverOption ->
                DriverOptionResponse(
                    id = driverOption.id,
                    name = driverOption.name,
                    description = driverOption.description,
                    vehicle = driverOption.vehicle,
                    review = ReviewResponse(
                        rating = driverOption.review.rating,
                        comment = driverOption.review.comment
                    ),
                    value = driverOption.value
                )
            },
            routeResponse = domain.routeData
        )
    }

    override fun toDomain(entity: RideEstimationResponse): RideEstimate {
        return RideEstimate(
            origin = Location(
                latitude = entity.origin.latitude,
                longitude = entity.origin.longitude
            ),
            destination = Location(
                latitude = entity.destination.latitude,
                longitude = entity.destination.longitude
            ),
            distance = entity.distance,
            duration = entity.duration,
            driverOptions = entity.options.map { driverOption ->
                DriverOption(
                    id = driverOption.id,
                    name = driverOption.name,
                    description = driverOption.description,
                    vehicle = driverOption.vehicle,
                    review = Review(
                        rating = driverOption.review.rating,
                        comment = driverOption.review.comment
                    ),
                    value = driverOption.value
                )
            },
            routeData = entity.routeResponse
        )
    }

}