package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Car

interface CarRepositoryInterface {
    val selectedCar: Car?

    fun fetch(callback: (List<Car>) -> Unit)
    fun fetch(id: String, callback: (Car) -> Unit)
}