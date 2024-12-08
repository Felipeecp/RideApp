package io.github.felipeecp.rideapp.data.api.service

import io.github.felipeecp.rideapp.data.dto.request.RideConfirmRequest
import io.github.felipeecp.rideapp.data.dto.request.RideEstimateRequest
import io.github.felipeecp.rideapp.data.dto.response.RideEstimationResponse
import io.github.felipeecp.rideapp.data.dto.response.RideHistoryResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RideService {
    @POST("/rides/estimate")
    suspend fun estimateRide(
        @Body request: RideEstimateRequest
    ): Response<RideEstimationResponse>

    @PATCH("/rides/confirm")
    suspend fun confirmRide(
        @Body request: RideConfirmRequest
    ): Response<Unit>

    @GET("ride/{customerId}")
    suspend fun getRideHistory(
        @Path("customerId") customerId: String,
        @Query("driver_id") driverId: Int?
    ): Response<RideHistoryResponse>
}