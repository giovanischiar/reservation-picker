package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.Star.FIRST_CLASS
import io.schiar.tcc.model.repository.CarRepository.Companion.instance
import io.schiar.tcc.model.repository.HotelRepository.Companion.instance

/**
 * Implementação de um repository de hotéis. Fornece os dados a respeito dos
 * hotéis disponíveis para reserva.
 *
 * Por motivos de simplificação, essa classe gera dados de hotéis para a aplicação
 * e os mantém em memória durante a execução. Numa aplicação real, essa classe se comunicaria
 * com as diferentes camadas de dados da aplicação, como por exemplo serviços e persistência.
 *
 * @property simplifiedHotels hotéis gerados para a tela de lista de hotéis.
 * Numa aplicação real, esses objetos viriam de uma camada de dados da aplicação.
 * @property hotels hotéis gerados para serem exibidos na tela de detalhes do hotel.
 * Numa aplicação real, esses objetos viriam de uma camada de dados da aplicação.
 * @property instance instância de HotelRepository compartilhada com diferentes componentes da aplicação.
 * Essa instância difere um pouco da implementação tradicional do padrão singleton em Kotlin, a qual define a classe como um object.
 * Prefere-se definir a instância compartilhada de HotelRepository dessa forma pois essa abordagem não
 * impede que outras instâncias de HotelRepository sejam criadas, o que possibilita que a classe seja testada
 * com testes unitários.
 * @property selectedHotel hotel candidato a ser reservado.
 */
@Suppress("SpellCheckingInspection")
class HotelRepository : HotelRepositoryInterface {

    private val simplifiedHotels: List<Hotel> = listOf(
        Hotel("0",
            "Majestic Palace Hotel",
            "https://upload.wikimedia.org/wikipedia/commons/b/b1/Majestic_Palace_Hotel_%2822089938466%29.jpg"),
        Hotel("1",
            "Costão do Santinho Resort",
            "https://live.staticflickr.com/3695/13706481074_b3a9be8f81_k.jpg")
    )

    private val hotels: List<Hotel> = listOf(
        Hotel("0",
            "Majestic Palace Hotel",
            "https://upload.wikimedia.org/wikipedia/commons/b/b1/Majestic_Palace_Hotel_%2822089938466%29.jpg",
            "Av. Jorn. Rubéns de Arruda Ramos, 2746, Florianópolis, Brasil",
            "+55 48 3231-8000",
            "http://majesticpalace.com.br",
            listOf("Free WiFi", "Free Breakfast", "Minibar", "Air Conditioner", "TV"),
            FIRST_CLASS),
        Hotel("1",
            "Costão do Santinho Resort",
            "https://live.staticflickr.com/3695/13706481074_b3a9be8f81_k.jpg",
            "Estr. Ver. Onildo Lemos, 2505, Florianópolis, Brasil",
            "+55 48 3261-1000",
            "http://costao.com.br",
            listOf("Free Parking", "Minibar", "Air Conditioner", "TV"),
            FIRST_CLASS)
    )

    companion object {
        val instance: HotelRepositoryInterface = HotelRepository()
    }

    private var currentHotel: Hotel? = null

    override val selectedHotel: Hotel?
        get() = currentHotel

    /**
     * Busca a lista de hotéis a ser exibida na View.
     * @param callback usado para receber a lista de hotéis buscada.
     */
    override fun fetch(callback: (List<Hotel>) -> Unit) {
        callback(simplifiedHotels)
    }

    /**
     * Busca os detalhes de um hotel a ser exibido na View.
     * @param id identificador do hotel.
     * @param callback usado para receber o hotel buscado.
     */
    override fun fetch(id: String, callback: (Hotel) -> Unit) {
        val hotel = hotels.first { it.id == id }
        currentHotel = hotel
        callback(hotel)
    }
}