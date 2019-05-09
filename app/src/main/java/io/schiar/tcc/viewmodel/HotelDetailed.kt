package io.schiar.tcc.viewmodel

import io.schiar.tcc.utilities.BitmapLoader

data class HotelDetailed(
    val name: String,
    val photo: BitmapLoader,
    val address: String,
    val phone: String,
    val website: String,
    val amenities: List<String>,
    val stars: Int
)