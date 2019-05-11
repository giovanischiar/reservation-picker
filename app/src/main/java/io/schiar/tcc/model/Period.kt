package io.schiar.tcc.model

/**
 * Período de uma reserva.
 * @property begin início em milisegundos desde o unixtime
 * @property end término em milisegundos desde o unixtime
 */
data class Period(
    val begin: Long,
    val end: Long
)