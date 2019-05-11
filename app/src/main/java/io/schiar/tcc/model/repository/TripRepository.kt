package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Car
import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.Period
import io.schiar.tcc.model.Trip
import io.schiar.tcc.model.repository.CarRepository.Companion.instance
import io.schiar.tcc.model.repository.HotelRepository.Companion.instance

/**
 * Gerador de dado de viagem para a aplicacação.
 * @property instance singleton usado na aplicação para configurar a viagem.
 * @property trip a viagem atual.
 */
class TripRepository: TripRepositoryInterface {
    companion object {
        val instance: TripRepositoryInterface = TripRepository()
    }

    private var trip: Trip = Trip("0", null, null, null, null, null)

    /**
     * Busca a viagem a ser exibida na View.
     * @param callback usado para receber a viagem buscada.
     */
    override fun fetch(callback: (Trip) -> Unit) {
        callback(trip)
    }

    /**
     * Atualiza a viagem com a reserva de carro selecionada.
     * @param car reserva do carro.
     * @param callback usado para receber a viagem atualizada.
     */
    override fun selectCar(car: Car, callback: (Trip) -> Unit) {
        trip.car = car
        callback(trip)
    }

    /**
     * Atualiza a viagem com a reserva de hotel selecionada.
     * @param hotel reserva do hotel.
     * @param callback usado para receber a viagem atualizada.
     */
    override fun selectHotel(hotel: Hotel, callback: (Trip) -> Unit) {
        trip.hotel = hotel
        callback(trip)
    }

    /**
     * Atualiza a viagem com o período selecionado.
     * @param period período da reserva.
     * @param callback usado para receber a viagem atualizada.
     */
    override fun selectPeriod(period: Period, callback: (Trip) -> Unit) {
        trip.period = period
        callback(trip)
    }

    /**
     * Atualiza a viagem com a quantidade de adultos selecionado.
     * @param adults quantidade de adultos da reserva.
     * @param callback usado para receber a viagem atualizada.
     */
    override fun selectAdults(adults: Int, callback: (Trip) -> Unit) {
        trip.adults = adults
        callback(trip)
    }

    /**
     * Atualiza a viagem com a quantidade de crianças selecionado.
     * @param adults quantidade de crianças da reserva.
     * @param callback usado para receber a viagem atualizada.
     */
    override fun selectChildren(children: Int, callback: (Trip) -> Unit) {
        trip.children = children
        callback(trip)
    }
}