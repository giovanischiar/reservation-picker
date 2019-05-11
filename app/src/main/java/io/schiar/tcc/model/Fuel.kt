package io.schiar.tcc.model

/**
 * Tipos de combustível associada com string representativa.
 * @property stringValue string que representa o tipo de combustível.
 */
enum class Fuel(val stringValue: String) {
    GASOLINE("Gasoline"),
    ETHANOL("Ethanol"),
    FLEX("Flex"),
    ELECTRIC("Electric"),
    DIESEL("Diesel"),
    NATURAL_GAS("Natural Gas"),
    BIO_DIESEL("Bio-Diesel"),
    HYBRID("Hybrid")
}