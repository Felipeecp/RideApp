package io.github.felipeecp.rideapp.data.mapper

interface BaseMapper<T, D> {
    fun toDomain(entity: T): D
    fun fromDomain(entity: D): T
}