package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Car
import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.Period
import io.schiar.tcc.model.Trip

/**
 * Contrato de um fornecedor de dados para a aplicação.
 */
interface TripRepositoryInterface {

    /**
     * Busca a viagem a ser exibida na View.
     * @param callback usado para receber a viagem buscada.
     */
    fun fetch(callback: (Trip) -> Unit)

    /**
     * Atualiza a viagem com a reserva de carro selecionada.
     * @param car reserva do carro.
     * @param callback usado para receber a viagem atualizada.
     */
    fun selectCar(car: Car, callback: (Trip) -> Unit)

    /**
     * Atualiza a viagem com a reserva de hotel selecionada.
     * @param hotel reserva do hotel.
     * @param callback usado para receber a viagem atualizada.
     */
    fun selectHotel(hotel: Hotel, callback: (Trip) -> Unit)

    /**
     * Atualiza a viagem com o período selecionado.
     * @param period período da reserva.
     * @param callback usado para receber a viagem atualizada.
     */
    fun selectPeriod(period: Period, callback: (Trip) -> Unit)

    /**
     * Atualiza a viagem com a quantidade de adultos selecionado.
     * @param adults quantidade de adultos da reserva.
     * @param callback usado para receber a viagem atualizada.
     */
    fun selectAdults(adults: Int, callback: (Trip) -> Unit)

    /**
     * Atualiza a viagem com a quantidade de crianças selecionado.
     * @param adults quantidade de crianças da reserva.
     * @param callback usado para receber a viagem atualizada.
     */
    fun selectChildren(children: Int, callback: (Trip) -> Unit)
}