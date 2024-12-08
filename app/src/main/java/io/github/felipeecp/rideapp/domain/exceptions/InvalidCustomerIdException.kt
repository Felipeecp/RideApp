package io.github.felipeecp.rideapp.domain.exceptions

sealed class DomainException: Exception() {
    class InvalidCustomerIdException : DomainException()
    class InvalidOriginException : DomainException()
    class InvalidDestinationException : DomainException()
    class SameLocationException : DomainException()
    class InvalidDistanceException : DomainException()
    class InvalidDriverException : DomainException()
}
