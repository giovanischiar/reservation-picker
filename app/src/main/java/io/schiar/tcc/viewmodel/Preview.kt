package io.schiar.tcc.viewmodel

import io.schiar.tcc.utilities.BitmapLoader

/**
 * Visão simplificada de um item (hotel/carro) do ponto de vista da visão.
 * @property photo carregador de imagem de um item.
 * @property name título de um item.
 */
data class Preview(
    val photo: BitmapLoader,
    val name: String
)