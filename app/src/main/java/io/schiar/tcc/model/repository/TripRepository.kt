package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Car
import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.Period
import io.schiar.tcc.model.Trip

class TripRepository: TripRepositoryInterface {
    companion object {
        val instance: TripRepositoryInterface = TripRepository()
    }

    private var trip: Trip = Trip("0", null, null, null, null, null)

    override fun fetch(callback: (Trip) -> Unit) {
        callback(trip)
    }

    override fun selectCar(car: Car, callback: (Trip) -> Unit) {
        trip.car = car
        callback(trip)
    }

    override fun selectHotel(hotel: Hotel, callback: (Trip) -> Unit) {
        trip.hotel = hotel
        callback(trip)
    }

    override fun selectPeriod(period: Period, callback: (Trip) -> Unit) {
        trip.period = period
        callback(trip)
    }

    override fun selectAdults(adults: Int, callback: (Trip) -> Unit) {
        trip.adults = adults
        callback(trip)
    }

    override fun selectChildren(children: Int, callback: (Trip) -> Unit) {
        trip.children = children
        callback(trip)
    }
}