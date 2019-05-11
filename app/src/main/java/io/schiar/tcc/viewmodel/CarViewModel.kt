package io.schiar.tcc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.schiar.tcc.model.Car
import io.schiar.tcc.model.repository.CarRepository
import io.schiar.tcc.model.repository.CarRepositoryInterface
import io.schiar.tcc.utilities.BitmapLoader

class CarViewModel(private val carRepository: CarRepositoryInterface = CarRepository.instance): ViewModel() {
    private var currentCars: List<Car> = emptyList()

    val cars: MutableLiveData<List<Preview>> by lazy {
        MutableLiveData<List<Preview>>()
    }

    val selectedCar: MutableLiveData<CarDetailed> by lazy {
        MutableLiveData<CarDetailed>()
    }

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

    fun fetch(index: Int) {
        val selectedCar = currentCars[index]
        carRepository.fetch(selectedCar.id, ::updateSelectedCar)
    }

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