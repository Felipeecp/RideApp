package io.github.felipeecp.rideapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.felipeecp.rideapp.data.api.service.RideService
import io.github.felipeecp.rideapp.data.mapper.RideEstimateMapper
import io.github.felipeecp.rideapp.data.mapper.RideHistoryMapper
import io.github.felipeecp.rideapp.data.repository.RideRepositoryImpl
import io.github.felipeecp.rideapp.domain.repository.RideRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Provides
    @Singleton
    fun provideRideRepository(
        service: RideService,
        rideEstimateMapper: RideEstimateMapper,
        rideHistoryMapper: RideHistoryMapper
    ): RideRepository{
        return RideRepositoryImpl(
            service = service,
            rideEstimateMapper = rideEstimateMapper,
            rideHistoryMapper = rideHistoryMapper
        )
    }

}