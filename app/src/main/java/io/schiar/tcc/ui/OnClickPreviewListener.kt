package io.schiar.tcc.ui

import android.view.View

/**
 * Define listener de quando um item de lista de hotel ou carro é clicado.
 */
interface OnClickPreviewListener {
    /**
     * Evento de clique de um item de lista de hotel ou carro.
     * @param index índice do item.
     * @param view componente [View] do item.
     */
    fun onPreviewClick(index: Int, view: View)
}