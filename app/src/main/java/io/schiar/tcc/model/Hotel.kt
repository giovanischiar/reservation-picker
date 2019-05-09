package io.schiar.tcc.model

data class Hotel(
    val id: String,
    val name: String,
    val photo: String,
    val address: String?,
    val phone: String?,
    val website: String?,
    val amenities: List<String>?,
    val stars: Star?
) {
    constructor(id: String, name: String, photo: String) : this(id, name, photo, null, null, null, null, null)
}