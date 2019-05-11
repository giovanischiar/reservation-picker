package io.schiar.tcc.model

/**
 * Categoria de hotel associada com número de estrelas.
 * @property intValue quantidade de estrelas.
 */
enum class Star(val intValue: Int) {
    TOURIST(1),
    STANDARD(2),
    COMFORT(3),
    FIRST_CLASS(4),
    LUXURY(5)
}