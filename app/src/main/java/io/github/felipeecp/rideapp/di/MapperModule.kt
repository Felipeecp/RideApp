package io.github.felipeecp.rideapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.felipeecp.rideapp.data.mapper.RideEstimateMapper
import io.github.felipeecp.rideapp.data.mapper.RideHistoryMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule{

    @Provides
    @Singleton
    fun provideRideMapper(): RideEstimateMapper {
        return RideEstimateMapper()
    }

    @Provides
    @Singleton
    fun provideDriverMapper(): RideHistoryMapper {
        return RideHistoryMapper()
    }

}