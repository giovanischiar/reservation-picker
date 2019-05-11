package io.schiar.tcc.ui

import android.text.Editable

/**
 * Converte a string gerada pelo evento de mudança de texto para um inteiro.
 */
object EditableToIntConverter {

    /**
     * Realiza a conversão de uma string gerada pelo evento de mudança de texto para um inteiro.
     * @param e representa a string a ser convertida pelo evento de mudança de texto para um inteiro.
     * @return um inteiro, 0 caso seja uma string vazia.
     */
    @JvmStatic
    fun convert(e: Editable): Int {
        val newString = e.toString().replace("[^\\d]".toRegex(), "" )
        if (newString.isEmpty()) {
            return 0
        }

        return newString.toInt()
    }
}