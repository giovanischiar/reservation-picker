package io.schiar.tcc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.repository.HotelRepository
import io.schiar.tcc.model.repository.HotelRepositoryInterface
import io.schiar.tcc.utilities.BitmapLoader

class HotelViewModel(private val hotelRepository: HotelRepositoryInterface = HotelRepository.instance): ViewModel() {
    private var currentHotels: List<Hotel> = emptyList()

    val hotels: MutableLiveData<List<Preview>> by lazy {
        MutableLiveData<List<Preview>>()
    }

    val selectedHotel: MutableLiveData<HotelDetailed> by lazy {
        MutableLiveData<HotelDetailed>()
    }

    fun fetch() {
        hotelRepository.fetch { hotels ->
            this.currentHotels = hotels
            val hotelPreviews = hotels.map { hotel ->
                val bitmapLoader = BitmapLoader(hotel.photo)
                return@map Preview(bitmapLoader, hotel.name)
            }
            this.hotels.postValue(hotelPreviews)
        }
    }

    fun fetch(index: Int) {
        val selectedHotel = currentHotels[index]
        hotelRepository.fetch(selectedHotel.id, ::updateSelectedHotel)
    }

    private fun updateSelectedHotel(hotel: Hotel) {
        val address = hotel.address ?: return
        val phone = hotel.phone ?: return
        val website = hotel.website ?: return
        val amenities = hotel.amenities ?: return
        val stars = hotel.stars?.intValue ?: return
        val hotelDetailed = HotelDetailed(
            hotel.name,
            BitmapLoader(hotel.photo),
            address,
            phone,
            website,
            amenities,
            stars
        )
        this.selectedHotel.postValue(hotelDetailed)
    }
}