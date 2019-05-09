package io.schiar.tcc.viewmodel

import io.schiar.tcc.utilities.BitmapLoader

data class CarDetailed(
    val name: String,
    val photo: BitmapLoader,
    val year: Int,
    val brand: String,
    val fuel: String,
    val description: String
)