package io.schiar.tcc.ui

import android.view.View
import io.schiar.tcc.R

object TripFormatter {

    @JvmStatic
    fun formatAdultChildren(view: View, adults: Int?, children: Int?): String {
        val stringBuilder = StringBuilder()
        if (adults != null && adults != 0) {
            val resourceString = view.context.resources.getQuantityString(R.plurals.adults, adults)
            val stringFormatted = String.format(resourceString, adults)
            stringBuilder.append(stringFormatted)
        }

        if (children != null && children != 0) {
            val resourceString = view.context.resources.getQuantityString(R.plurals.children, children)
            val stringFormatted = String.format(resourceString, children)
            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(", ")
            }
            stringBuilder.append(stringFormatted)
        }

        return stringBuilder.toString()
    }

}