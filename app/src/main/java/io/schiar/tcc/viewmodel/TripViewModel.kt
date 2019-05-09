package io.schiar.tcc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.schiar.tcc.model.Period
import io.schiar.tcc.model.Trip
import io.schiar.tcc.model.repository.*
import io.schiar.tcc.utilities.BitmapLoader
import io.schiar.tcc.utilities.DateFormatter

class TripViewModel(private val tripRepository: TripRepositoryInterface = TripRepository): ViewModel() {
    val trip: MutableLiveData<Reservation> by lazy {
        MutableLiveData<Reservation>()
    }

    fun addCarToTrip(carRepository: CarRepositoryInterface = CarRepository) {
        val selectedCar = carRepository.selectedCar ?: return
        tripRepository.addCar(selectedCar, ::updateTrip)
    }

    fun addHotelToTrip(hotelRepository: HotelRepositoryInterface = HotelRepository) {
        val selectedHotel = hotelRepository.selectedHotel ?: return
        tripRepository.addHotel(selectedHotel, ::updateTrip)
    }

    fun addPeriodToTrip(initDate: Long, endDate: Long) {
        val period = Period(initDate, endDate)
        tripRepository.addPeriod(period, ::updateTrip)
    }

    fun addAdultsToTrip(adults: Int) {
        tripRepository.addAdults(adults, ::updateTrip)
    }

    fun addChildrenToTrip(children: Int) {
        tripRepository.addChildren(children, ::updateTrip)
    }

    private fun updateTrip(trip: Trip) {
        var carPreview: Preview? = null
        trip.car?.let {
            carPreview = Preview(BitmapLoader(it.photo), it.name)
        }

        var hotelPreview: Preview? = null
        trip.hotel?.let {
            hotelPreview = Preview(BitmapLoader(it.photo), it.name)
        }

        var beginDate: String? = null
        var endDate: String? = null
        trip.period?.let {
            val dateFormatter = DateFormatter()
            beginDate = dateFormatter.dateString(it.begin)
            endDate = dateFormatter.dateString(it.end)
        }

        val reservation = Reservation(carPreview, hotelPreview, beginDate, endDate, trip.adults, trip.children)
        this.trip.postValue(reservation)
    }
}