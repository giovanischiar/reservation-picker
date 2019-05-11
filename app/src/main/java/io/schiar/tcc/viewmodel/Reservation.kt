package io.schiar.tcc.viewmodel

/**
 * Detalhes de uma reserva de hotel e/ou carro.
 * @property carPreview foto e nome do carro reservado.
 * @property hotelPreview foto e nome do hotel reservado.
 * @property beginDatem data formatada de início de uma reserva.
 * @property endDate data formatada de término de uma reserva.
 * @property adults quantidade de adultos de uma reserva.
 * @property children quantidade de crianças de uma reserva.
 */
data class Reservation(
    var carPreview: Preview?,
    var hotelPreview: Preview?,
    val beginDate: String?,
    val endDate: String?,
    var adults: Int?,
    var children: Int?
)