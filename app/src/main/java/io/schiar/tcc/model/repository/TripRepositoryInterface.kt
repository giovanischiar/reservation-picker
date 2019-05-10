package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Car
import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.Period
import io.schiar.tcc.model.Trip

interface TripRepositoryInterface {
    fun fetch(callback: (Trip) -> Unit)
    fun selectCar(car: Car, callback: (Trip) -> Unit)
    fun selectHotel(hotel: Hotel, callback: (Trip) -> Unit)
    fun selectPeriod(period: Period, callback: (Trip) -> Unit)
    fun selectAdults(adults: Int, callback: (Trip) -> Unit)
    fun selectChildren(children: Int, callback: (Trip) -> Unit)
}