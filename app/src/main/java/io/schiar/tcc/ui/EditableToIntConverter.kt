package io.schiar.tcc.ui

import android.text.Editable

object EditableToIntConverter {

    @JvmStatic
    fun convert(e: Editable): Int {
        val newString = e.toString().replace("[^\\d]".toRegex(), "" )
        if (newString.isEmpty()) {
            return 0
        }

        return newString.toInt()
    }
}