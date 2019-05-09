package io.schiar.tcc.viewmodel

data class Reservation(
    var carPreview: Preview?,
    var hotelPreview: Preview?,
    val beginDate: String?,
    val endDate: String?,
    var adults: Int?,
    var children: Int?
)