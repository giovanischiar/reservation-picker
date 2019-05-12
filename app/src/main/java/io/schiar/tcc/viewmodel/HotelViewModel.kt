package io.schiar.tcc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.schiar.tcc.model.Hotel
import io.schiar.tcc.model.repository.HotelRepository
import io.schiar.tcc.model.repository.HotelRepositoryInterface
import io.schiar.tcc.utilities.BitmapLoader

/**
 * Recebe mensagens da visão solicitando dados dos hotéis disponíveis para reserva.
 * Formata esses dados e os disponibiliza para a visão através dos objetos LiveData.
 * @property hotelRepository fornecedor de objetos de modelo para a View.
 * @property currentHotels lista atual de hotéis.
 * @property hotels lista de hotéis com dados de foto e nome de cada hotel. Utiliza-se o wrapper LiveData para as mudanças na lista serem
 * atualizadas pela View.
 * @property selectedHotel detalhes do hotel atual selecionado. Utiliza-se o wrapper LiveData para as mudanças no hotel selecionado
 * serem atualizadas pela View.
 */
class HotelViewModel(private val hotelRepository: HotelRepositoryInterface = HotelRepository.instance) : ViewModel() {
    private var currentHotels: List<Hotel> = emptyList()

    val hotels: MutableLiveData<List<Preview>> by lazy {
        MutableLiveData<List<Preview>>()
    }

    val selectedHotel: MutableLiveData<HotelDetailed> by lazy {
        MutableLiveData<HotelDetailed>()
    }

    /**
     * Busca os dados de hotéis e atualiza o LiveData de [hotels].
     */
    fun fetch() {
        hotelRepository.fetch { hotels ->
            this.currentHotels = hotels
            val hotelPreviews = hotels.map { hotel ->
                val bitmapLoader = BitmapLoader(hotel.photo)
                return@map Preview(bitmapLoader, hotel.name)
            }
            this.hotels.postValue(hotelPreviews)
        }
    }

    /**
     * Busca os detalhes de um hotel e atualiza o LiveData de [selectedHotel].
     * @param índice de um hotel na lists.
     */
    fun fetch(index: Int) {
        val selectedHotel = currentHotels[index]
        hotelRepository.fetch(selectedHotel.id, ::updateSelectedHotel)
    }

    /**
     * Constrói o objeto a ter seus atributos exibidos na View a partir do objeto de modelo, e atualiza o LiveData de
     * [selectedHotel]
     * @param hotel o objeto de modelo de uma reserva de hotel.
     */
    private fun updateSelectedHotel(hotel: Hotel) {
        val address = hotel.address ?: return
        val phone = hotel.phone ?: return
        val website = hotel.website ?: return
        val amenities = hotel.amenities ?: return
        val stars = hotel.stars?.intValue ?: return
        val hotelDetailed = HotelDetailed(
            hotel.name,
            BitmapLoader(hotel.photo),
            address,
            phone,
            website,
            amenities,
            stars
        )
        this.selectedHotel.postValue(hotelDetailed)
    }
}