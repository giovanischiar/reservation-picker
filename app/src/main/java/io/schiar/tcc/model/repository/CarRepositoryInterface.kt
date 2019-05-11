package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Car

/**
 * Contrato de um fornecedor de dados para a aplicação.
 * @property selectedCar carro atual selecionado.
 */
interface CarRepositoryInterface {
    val selectedCar: Car?

    /**
     * Busca a lista de carros a ser exibida na View.
     * @param callback usado para receber a lista de carros buscada.
     */
    fun fetch(callback: (List<Car>) -> Unit)

    /**
     * Busca os detalhes de um carro a ser exibida na View.
     * @param id identificador do carro.
     * @param callback usado para receber o carro buscado.
     */
    fun fetch(id: String, callback: (Car) -> Unit)
}