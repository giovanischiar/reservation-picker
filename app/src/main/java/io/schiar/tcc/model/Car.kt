package io.schiar.tcc.model

data class Car(
    val id: String,
    val name: String,
    val photo: String,
    val year: Int?,
    val brand: String?,
    val fuel: Fuel?,
    val description: String?
) {
    constructor(id: String, name: String, photo: String) : this(id, name, photo, null, null, null, null)
}