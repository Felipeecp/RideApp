package io.github.felipeecp.rideapp.presentation.navigation

sealed class Screen(val route: String) {
    object RequestRide: Screen("request")
    object RideOptions: Screen("options")
    object RideHistory: Screen("history")
}