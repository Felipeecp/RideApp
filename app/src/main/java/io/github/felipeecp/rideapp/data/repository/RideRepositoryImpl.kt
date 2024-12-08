package io.github.felipeecp.rideapp.data.repository

import io.github.felipeecp.rideapp.data.api.service.RideService
import io.github.felipeecp.rideapp.data.dto.request.DriverRequest
import io.github.felipeecp.rideapp.data.dto.request.RideConfirmRequest
import io.github.felipeecp.rideapp.data.dto.request.RideEstimateRequest
import io.github.felipeecp.rideapp.data.mapper.RideEstimateMapper
import io.github.felipeecp.rideapp.data.mapper.RideHistoryMapper
import io.github.felipeecp.rideapp.domain.model.Driver
import io.github.felipeecp.rideapp.domain.model.Ride
import io.github.felipeecp.rideapp.domain.model.RideEstimate
import io.github.felipeecp.rideapp.domain.repository.RideRepository
import javax.inject.Inject

class RideRepositoryImpl @Inject constructor(
    private val service: RideService,
    private val rideEstimateMapper: RideEstimateMapper,
    private val rideHistoryMapper: RideHistoryMapper
): RideRepository{

    override suspend fun estimeRide(
        customerId: String,
        origin: String,
        destination: String
    ): Result<RideEstimate> {
        return try {
            val request = RideEstimateRequest(
                customer_id = customerId,
                origin = origin,
                destination = destination
            )

            val response = service.estimateRide(request)

            if(response.isSuccessful){
                response.body()?.let {
                    Result.success(rideEstimateMapper.toDomain(it))
                } ?: Result.failure(Exception("Body is null"))
            }else{
                Result.failure(Exception(response.errorBody()?.string()))
            }
        }catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun confirmRide(
        customerId: String,
        origin: String,
        destination: String,
        distance: Double,
        duration: String,
        driver: Driver,
        value: Double,
    ): Result<Unit> {
        return try {
            val request = RideConfirmRequest(
                customer_id = customerId,
                origin = origin,
                destination = destination,
                distance = distance,
                duration = duration,
                driver = DriverRequest(
                    id = driver.id,
                    name = driver.name
                ),
                value = value
            )

            val response = service.confirmRide(request)

            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


    override suspend fun getRideHistory(
        customerId: String,
        driverId: Int?
    ): Result<List<Ride>> {
        return try {
            val response = service.getRideHistory(customerId, driverId)

            if (response.isSuccessful) {
                response.body()?.let { historyResponse ->
                    Result.success(
                        historyResponse.rides.map { rideHistoryMapper.toDomain(it) }
                    )
                } ?: Result.failure(Exception("Empty response body"))
            } else {
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}