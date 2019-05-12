package io.schiar.tcc.viewmodel

import io.schiar.tcc.utilities.BitmapLoader

/**
 * Representação dos detalhes da reserva de um hotel do ponto de vista da visão.
 * @property name nome de um hotel.
 * @property photo carregador de imagem de um hotel.
 * @property address endereço de um hotel.
 * @property phone telefone de um hotel.
 * @property website site de um hotel.
 * @property amenities lista de amenidades de um hotel.
 * @property stars quantidade de estrelas de um hotel.
 */
data class HotelDetailed(
    val name: String,
    val photo: BitmapLoader,
    val address: String,
    val phone: String,
    val website: String,
    val amenities: List<String>,
    val stars: Int
)