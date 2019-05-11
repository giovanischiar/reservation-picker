package io.schiar.tcc.utilities

import java.text.DateFormat
import java.util.*

/**
 * Formata datas.
 */
class DateFormatter {
    /**
     * Formata uma data em milisegundos desde o unixtime para uma representação em string seguindo o formato brasileiro.
     * @param millisecondsSinceEpoch data em milisegundos desde o unixtime.
     * @return a data formatada em string seguindo o formato brasileiro (DD/MM/AAAA).
     */
    fun dateString(millisecondsSinceEpoch: Long): String {
        val date = Date(millisecondsSinceEpoch)
            val formatter = DateFormat.getDateInstance(DateFormat.SHORT, Locale("pt", "BR"))
        return formatter.format(date)
    }
}