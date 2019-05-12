package io.schiar.tcc.model

/**
 * Período de uma reserva.
 * @property begin início em milissegundos desde o unixtime
 * @property end término em milissegundos desde o unixtime
 */
data class Period(
    val begin: Long,
    val end: Long
)