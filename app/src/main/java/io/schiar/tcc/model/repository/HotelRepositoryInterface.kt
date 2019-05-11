package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Hotel

/**
 * Contrato de um fornecedor de dados para a aplicação.
 * @property selectedHotel hotel atual selecionado.
 */
interface HotelRepositoryInterface {
    val selectedHotel: Hotel?

    /**
     * Busca a lista de hotéis a ser exibida na View.
     * @param callback usado para receber a lista de hotéis buscada.
     */
    fun fetch(callback: (List<Hotel>) -> Unit)

    /**
     * Busca os detalhes de um hotel a ser exibido na View.
     * @param id identificador do hotel.
     * @param callback usado para receber o hotel buscado.
     */
    fun fetch(id: String, callback: (Hotel) -> Unit)
}