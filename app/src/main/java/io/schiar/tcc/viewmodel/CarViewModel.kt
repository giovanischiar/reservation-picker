package io.schiar.tcc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.schiar.tcc.model.Car
import io.schiar.tcc.model.repository.CarRepository
import io.schiar.tcc.model.repository.CarRepositoryInterface
import io.schiar.tcc.utilities.BitmapLoader

/**
 * Formata dados do modelo para serem enviados para serem exibidos na View.
 * @property carRepository fornecedor de objetos de modelo para a View.
 * @property currentCars lista atual de carros.
 * @property cars lista de dados de foto e nome de carros. Utiliza-se o wrapper LiveData para as mudanças na lista serem
 * atualizadas pela View.
 * @property selectedCar detalhes do carro atual selecionado. Utiliza-se o wrapper LiveData para as mudanças na lista
 * serem atualizadas pela View.
 */
class CarViewModel(private val carRepository: CarRepositoryInterface = CarRepository.instance): ViewModel() {
    private var currentCars: List<Car> = emptyList()

    val cars: MutableLiveData<List<Preview>> by lazy {
        MutableLiveData<List<Preview>>()
    }

    val selectedCar: MutableLiveData<CarDetailed> by lazy {
        MutableLiveData<CarDetailed>()
    }

    /**
     * Busca os dados de carros e atualiza o LiveData de [cars].
     */
    fun fetch() {
        carRepository.fetch { cars ->
            this.currentCars = cars
            val carPreviews = cars.map { car ->
                val bitmapLoader = BitmapLoader(car.photo)
                return@map Preview(bitmapLoader, car.name)
            }
            this.cars.postValue(carPreviews)
        }
    }

    /**
     * Busca os detalhes de um carro e atualiza o LiveData de [selectedCar].
     * @param índice de um carro na lists.
     */
    fun fetch(index: Int) {
        val selectedCar = currentCars[index]
        carRepository.fetch(selectedCar.id, ::updateSelectedCar)
    }

    /**
     * Constroi o objeto a ter seus atributos exibidos na View a partir do objeto de modelo, e Atualiza o LiveData de
     * [selectedCar]
     * @param car o objeto de modelo de uma reserva de carro.
     */
    private fun updateSelectedCar(car: Car) {
        val year = car.year ?: return
        val brand = car.brand ?: return
        val fuel = car.fuel?.stringValue ?: return
        val description = car.description ?: return
        val carDetailed = CarDetailed(
            car.name,
            BitmapLoader(car.photo),
            year,
            brand,
            fuel,
            description
        )
        this.selectedCar.postValue(carDetailed)
    }
}