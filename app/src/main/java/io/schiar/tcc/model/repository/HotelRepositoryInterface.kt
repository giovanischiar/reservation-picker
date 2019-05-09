package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Hotel

interface HotelRepositoryInterface {
    val selectedHotel: Hotel?

    fun fetch(callback: (List<Hotel>) -> Unit)
    fun fetch(id: String, callback: (Hotel) -> Unit)
}