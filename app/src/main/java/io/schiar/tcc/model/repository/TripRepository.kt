package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Car
import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.Period
import io.schiar.tcc.model.Trip
import io.schiar.tcc.model.repository.TripRepository.Companion.instance

/**
 * Implementação de um repository de uma viagem. Permite que uma viagem seja criada
 * e montada passo a passo por ações do usuário. Também fornece os dados a respeito da reserva
 * atual.
 *
 * Por motivos de simplificação, essa classe mantém os dados da viagem atual em memória durante a execução.
 * Numa aplicação real, essa classe se comunicaria com as diferentes camadas de dados da aplicação,
 * como por exemplo serviços e persistência.
 *
 * @property instance instância de TripRepository compartilhada com diferentes componentes da aplicação.
 * Essa instância difere um pouco da implementação tradicional do padrão singleton em Kotlin, a qual define a classe como um object.
 * Prefere-se definir a instância compartilhada de TripRepository dessa forma pois essa abordagem não
 * impede que outras instâncias de TripRepository sejam criadas, o que possibilita que a classe seja testada
 * com testes unitários.
 * @property trip a viagem atual.
 */
class TripRepository : TripRepositoryInterface {

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
     * Atualiza a viagem com a quantidade de adultos selecionada.
     * @param adults quantidade de adultos da reserva.
     * @param callback usado para receber a viagem atualizada.
     */
    override fun selectAdults(adults: Int, callback: (Trip) -> Unit) {
        trip.adults = adults
        callback(trip)
    }

    /**
     * Atualiza a viagem com a quantidade de crianças selecionada.
     * @param children quantidade de crianças da reserva.
     * @param callback usado para receber a viagem atualizada.
     */
    override fun selectChildren(children: Int, callback: (Trip) -> Unit) {
        trip.children = children
        callback(trip)
    }
}