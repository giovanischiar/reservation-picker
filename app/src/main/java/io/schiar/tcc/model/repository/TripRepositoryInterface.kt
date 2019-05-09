package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Car
import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.Period
import io.schiar.tcc.model.Trip

interface TripRepositoryInterface {
    fun fetch(callback: (Trip) -> Unit)
    fun addCar(car: Car, callback: (Trip) -> Unit)
    fun addHotel(hotel: Hotel, callback: (Trip) -> Unit)
    fun addPeriod(period: Period, callback: (Trip) -> Unit)
    fun addAdults(adults: Int, callback: (Trip) -> Unit)
    fun addChildren(children: Int, callback: (Trip) -> Unit)
}