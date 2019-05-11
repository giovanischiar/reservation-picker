package io.schiar.tcc.model

/**
 * Representa a reserva de um hotel.
 * @property id identificador.
 * @property name nome do hotel.
 * @property photo URL da imagem do hotel.
 * @property address endereço do hotel.
 * @property phone telefone do hotel.
 * @property website site do hotel.
 * @property amenities lista de amenidades do hotel.
 * @property stars categoria do hotel
 */
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
    /**
     * Forma reduzida de construir uma reserva de hotel, para a lista principal de hoteis.
     */
    constructor(id: String, name: String, photo: String) : this(id, name, photo, null, null, null, null, null)
}