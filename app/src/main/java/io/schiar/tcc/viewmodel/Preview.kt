package io.schiar.tcc.viewmodel

import io.schiar.tcc.utilities.BitmapLoader

data class Preview(
    val photo: BitmapLoader,
    val name: String
)