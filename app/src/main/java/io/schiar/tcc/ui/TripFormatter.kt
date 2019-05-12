package io.schiar.tcc.ui

import android.view.View
import io.schiar.tcc.R

/**
 * Formatação de dados de adultos e crianças da viagem.
 */
object TripFormatter {

    /**
     * Formata uma string de acordo com a quantidade de crianças e adultos definida. Se não há crianças ou adultos,
     * a informação é ocultada da string.
     * @param view onde formatar a string.
     * @param adults quantidade de adultos.
     * @param children quantidade de crianças.
     */
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