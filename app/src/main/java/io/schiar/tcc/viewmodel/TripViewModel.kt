package io.schiar.tcc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.schiar.tcc.model.Period
import io.schiar.tcc.model.Trip
import io.schiar.tcc.model.repository.*
import io.schiar.tcc.utilities.BitmapLoader
import io.schiar.tcc.utilities.DateFormatter

/**
 * Formata dados do modelo para serem enviados para serem exibidos na View.
 * @property tripRepository fornecedor de objetos de modelo para a View.
 * @property trip viagem atual.
 */
class TripViewModel(private val tripRepository: TripRepositoryInterface = TripRepository.instance): ViewModel() {
    val trip: MutableLiveData<Reservation> by lazy {
        MutableLiveData<Reservation>()
    }

    /**
     * Define no fornecedor de dados a reserva de carro selecionado.
     * @param carRepository forcedor de carros.
     **/
    fun addCarToTrip(carRepository: CarRepositoryInterface = CarRepository.instance) {
        val selectedCar = carRepository.selectedCar ?: return
        tripRepository.selectCar(selectedCar, ::updateTrip)
    }

    /**
     * Define no fornecedor de dados a reserva de hotel selecionado.
     * @param hotelRepository forcedor de hoteis.
     **/
    fun addHotelToTrip(hotelRepository: HotelRepositoryInterface = HotelRepository.instance) {
        val selectedHotel = hotelRepository.selectedHotel ?: return
        tripRepository.selectHotel(selectedHotel, ::updateTrip)
    }


    /**
     * Define no fornecedor de dados o período definido como datas no formato em milisegundos desde o unixtime.
     * @param initDate data de início no formato em milisegundos desde o unixtime.
     * @param endDate data de término no formato em milisegundos desde o unixtime.
     **/
    fun addPeriodToTrip(initDate: Long, endDate: Long) {
        val period = Period(initDate, endDate)
        tripRepository.selectPeriod(period, ::updateTrip)
    }

    /**
     * Define no fornecedor de dados a quntidade de adultos na reserva.
     * @param adults quantidade de adultos.
     **/
    fun addAdultsToTrip(adults: Int) {
        tripRepository.selectAdults(adults, ::updateTrip)
    }

    /**
     * Define no fornecedor de dados a quntidade de crianças na reserva.
     * @param children quantidade de crianças.
     **/
    fun addChildrenToTrip(children: Int) {
        tripRepository.selectChildren(children, ::updateTrip)
    }

    /**
     * Atualiza os LiveDatas da classe com os atributos do objeto de modelo viagem apenas os que não são nulos.
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