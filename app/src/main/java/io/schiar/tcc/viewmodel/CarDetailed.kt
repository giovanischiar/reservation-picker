package io.schiar.tcc.viewmodel

import io.schiar.tcc.utilities.BitmapLoader

/**
 * Representação dos detalhes da reserva de um carro do ponto de vista da visão.
 * @property name nome de um carro.
 * @property photo carregador de imagem de um carro.
 * @property year ano de fabricação de um carro.
 * @property brand marca de um carro.
 * @property description descrição de um carro.
 */
data class CarDetailed(
    val name: String,
    val photo: BitmapLoader,
    val year: Int,
    val brand: String,
    val fuel: String,
    val description: String
)