package io.schiar.tcc.model

/**
 * Representa uma viagem.
 * @property id identificador.
 * @property car reserva de um carro.
 * @property hotel reserva de um hotel.
 * @property period período de uma reserva.
 * @property adults quantidade de adultos.
 * @property children quantidade de crianças.
 */
data class Trip(
    val id: String,
    var car: Car?,
    var hotel: Hotel?,
    var period: Period?,
    var adults: Int?,
    var children: Int?
)