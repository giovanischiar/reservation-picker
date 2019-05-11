package io.schiar.tcc.model

/**
 * Representa a reserva de um carro.
 * @property id identificador.
 * @property name nome do carro.
 * @property photo URL da imagem do carro.
 * @property year ano de fabricação do carro.
 * @property brand marca do carro.
 * @property fuel tipo de combustível aceito pelo carro.
 * @property description breve descrição do carro.
 */
data class Car(
    val id: String,
    val name: String,
    val photo: String,
    val year: Int?,
    val brand: String?,
    val fuel: Fuel?,
    val description: String?
) {
    /**
     * Forma reduzida de construir uma reserva de carro, para os testes unitários.
     */
    constructor(id: String, name: String, photo: String) : this(id, name, photo, null, null, null, null)
}