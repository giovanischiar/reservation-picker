package io.schiar.tcc.utilities

import java.text.DateFormat
import java.util.*

class DateFormatter {
    fun dateString(millisecondsSinceEpoch: Long): String {
        val date = Date(millisecondsSinceEpoch)
            val formatter = DateFormat.getDateInstance(DateFormat.SHORT, Locale("pt", "BR"))
        return formatter.format(date)
    }
}