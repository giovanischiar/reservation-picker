package io.schiar.tcc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.schiar.tcc.model.Period
import io.schiar.tcc.model.Trip
import io.schiar.tcc.model.repository.*
import io.schiar.tcc.utilities.BitmapLoader
import io.schiar.tcc.utilities.DateFormatter

/**
 * Recebe mensagens da visão solicitando dados e adicionando novas informações na viagem atual.
 * Formata esses dados e os disponibiliza para a visão através do objeto LiveData.
 * @property tripRepository fornecedor de objetos de modelo para a View.
 * @property trip viagem atual. Utiliza-se o wrapper LiveData para as mudanças na viagem atual
 * serem atualizadas pela View.
 */
class TripViewModel(private val tripRepository: TripRepositoryInterface = TripRepository.instance) : ViewModel() {
    val trip: MutableLiveData<Reservation> by lazy {
        MutableLiveData<Reservation>()
    }

    /**
     * Define o carro atualmente selecionado como o carro escolhido para a viagem.
     * @param carRepository fornece informação a respeito do carro atualmente selecionado.
     **/
    fun addCarToTrip(carRepository: CarRepositoryInterface = CarRepository.instance) {
        val selectedCar = carRepository.selectedCar ?: return
        tripRepository.selectCar(selectedCar, ::updateTrip)
    }

    /**
     * Define o hotel atualmente selecionado como o hotel escolhido para a viagem.
     * @param hotelRepository fornece informação a respeito do hotel atualmente selecionado.
     **/
    fun addHotelToTrip(hotelRepository: HotelRepositoryInterface = HotelRepository.instance) {
        val selectedHotel = hotelRepository.selectedHotel ?: return
        tripRepository.selectHotel(selectedHotel, ::updateTrip)
    }

    /**
     * Define o período da viagem como datas no formato em milissegundos desde o unixtime.
     * @param initDate data de início no formato em milissegundos desde o unixtime.
     * @param endDate data de término no formato em milissegundos desde o unixtime.
     **/
    fun addPeriodToTrip(initDate: Long, endDate: Long) {
        val period = Period(initDate, endDate)
        tripRepository.selectPeriod(period, ::updateTrip)
    }

    /**
     * Define a quantidade de adultos da viagem.
     * @param adults quantidade de adultos.
     **/
    fun addAdultsToTrip(adults: Int) {
        tripRepository.selectAdults(adults, ::updateTrip)
    }

    /**
     * Define a quantidade de crianças da viagem.
     * @param children quantidade de crianças.
     **/
    fun addChildrenToTrip(children: Int) {
        tripRepository.selectChildren(children, ::updateTrip)
    }

    /**
     * Atualiza os LiveDatas da classe com os atributos do objeto de modelo viagem, se presentes.
     * @param trip o objeto de modelo de uma viagem.
     */
    private fun updateTrip(trip: Trip) {
        var carPreview: Preview? = null
        trip.car?.let {
            carPreview = Preview(BitmapLoader(it.photo), it.name)
        }

        var hotelPreview: Preview? = null
        trip.hotel?.let {
            hotelPreview = Preview(BitmapLoader(it.photo), it.name)
        }

        var beginDate: String? = null
        var endDate: String? = null
        trip.period?.let {
            val dateFormatter = DateFormatter()
            beginDate = dateFormatter.dateString(it.begin)
            endDate = dateFormatter.dateString(it.end)
        }

        val reservation = Reservation(carPreview, hotelPreview, beginDate, endDate, trip.adults, trip.children)
        this.trip.postValue(reservation)
    }
}