package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Car
import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.Period
import io.schiar.tcc.model.Trip

object TripRepository: TripRepositoryInterface {
    private var trip: Trip = Trip("0", null, null, null, null, null)

    override fun fetch(callback: (Trip) -> Unit) {
        callback(trip)
    }

    override fun addCar(car: Car, callback: (Trip) -> Unit) {
        trip.car = car
        callback(trip)
    }

    override fun addHotel(hotel: Hotel, callback: (Trip) -> Unit) {
        trip.hotel = hotel
        callback(trip)
    }

    override fun addPeriod(period: Period, callback: (Trip) -> Unit) {
        trip.period = period
        callback(trip)
    }

    override fun addAdults(adults: Int, callback: (Trip) -> Unit) {
        trip.adults = adults
        callback(trip)
    }

    override fun addChildren(children: Int, callback: (Trip) -> Unit) {
        trip.children = children
        callback(trip)
    }
}