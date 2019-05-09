package io.schiar.tcc.model

data class Trip(
    val id: String,
    var car: Car?,
    var hotel: Hotel?,
    var period: Period?,
    var adults: Int?,
    var children: Int?
)