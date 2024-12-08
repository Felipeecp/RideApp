package io.github.felipeecp.rideapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.felipeecp.rideapp.domain.repository.RideRepository
import io.github.felipeecp.rideapp.domain.usecase.ConfirmRideUseCase
import io.github.felipeecp.rideapp.domain.usecase.EstiateRideUseCase
import io.github.felipeecp.rideapp.domain.usecase.GetRideHistoryUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule{

    @Provides
    @Singleton
    fun provideEstiateRideUseCase(
        rideRepository: RideRepository
    ): EstiateRideUseCase {
        return EstiateRideUseCase(rideRepository)
    }

    @Provides
    @Singleton
    fun provideConfirmRideUseCase(
        rideRepository: RideRepository
    ): ConfirmRideUseCase {
        return ConfirmRideUseCase(rideRepository)
    }

    @Provides
    @Singleton
    fun provideGetRideHistoryUseCase(
        rideRepository: RideRepository
    ): GetRideHistoryUseCase {
        return GetRideHistoryUseCase(rideRepository)
    }
}