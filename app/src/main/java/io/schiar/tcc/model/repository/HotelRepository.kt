package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.Star.FIRST_CLASS

class HotelRepository: HotelRepositoryInterface {
    private val simplifiedHotels: List<Hotel> = listOf(
        Hotel("0",
            "Majestic Palace Hotel",
            "https://upload.wikimedia.org/wikipedia/commons/b/b1/Majestic_Palace_Hotel_%2822089938466%29.jpg"),
        Hotel("1",
            "Costão do Santinho Resort",
            "https://live.staticflickr.com/3695/13706481074_b3a9be8f81_k.jpg")
    )
    private val hotels: List<Hotel> = listOf(
        Hotel("0",
            "Majestic Palace Hotel",
            "https://upload.wikimedia.org/wikipedia/commons/b/b1/Majestic_Palace_Hotel_%2822089938466%29.jpg",
            "Av. Jorn. Rubéns de Arruda Ramos, 2746, Florianópolis, Brasil",
            "+55 48 3231-8000",
            "http://majesticpalace.com.br",
            listOf("Free WiFi", "Free Breakfast", "Minibar", "Air Conditioner", "TV"),
            FIRST_CLASS),
        Hotel("1",
            "Costão do Santinho Resort",
            "https://live.staticflickr.com/3695/13706481074_b3a9be8f81_k.jpg",
            "Estr. Ver. Onildo Lemos, 2505, Florianópolis, Brasil",
            "+55 48 3261-1000",
            "http://costao.com.br",
            listOf("Free Parking", "Minibar", "Air Conditioner", "TV"),
            FIRST_CLASS)
    )

    companion object {
        val instance: HotelRepositoryInterface = HotelRepository()
    }

    private var currentHotel: Hotel? = null

    override val selectedHotel: Hotel?
        get() = currentHotel

    override fun fetch(callback: (List<Hotel>) -> Unit) {
        callback(simplifiedHotels)
    }

    override fun fetch(id: String, callback: (Hotel) -> Unit) {
        val hotel = hotels.first { it.id == id }
        currentHotel = hotel
        callback(hotel)
    }
}