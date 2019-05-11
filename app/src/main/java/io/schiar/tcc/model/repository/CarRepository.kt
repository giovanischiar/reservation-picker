package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Car
import io.schiar.tcc.model.Fuel.GASOLINE
import io.schiar.tcc.model.Fuel.HYBRID

/**
 * Gerador de dados de carros para a aplicacação.
 * @property simplifiedCars carros gerados para a tela de lista de carros.
 * @property cars carros gerados para serem exibidos na View.
 * @property instance singleton usado na aplicação para buscar os carros.
 * @property selectedCar carro canditado a ser reservado.
 */
class CarRepository: CarRepositoryInterface {
    private val simplifiedCars: List<Car> = listOf(
        Car("0",
            "Jeep Renegade",
            "https://upload.wikimedia.org/wikipedia/commons/2/2e/Jeep_Renegade_1.6_MultiJet_2WD_Longitude_%E2%80%93_Frontansicht%2C_9._November_2014%2C_D%C3%BCsseldorf.jpg"),
        Car("1",
            "Toyota C-HR",
            "https://upload.wikimedia.org/wikipedia/commons/5/55/2017_Toyota_C-HR_%28NGX10R%29_Koba_2WD_hatchback_%282018-08-06%29_01.jpg")
    )
    private val cars: List<Car> = listOf(
        Car("0",
            "Jeep Renegade",
            "https://upload.wikimedia.org/wikipedia/commons/2/2e/Jeep_Renegade_1.6_MultiJet_2WD_Longitude_%E2%80%93_Frontansicht%2C_9._November_2014%2C_D%C3%BCsseldorf.jpg",
            2014,
            "Jeep",
            GASOLINE,
            "The Jeep Renegade is a subcompact crossover SUV produced by Jeep. The off-road vehicle was first shown to the public in March 2014 at the Geneva Motor Show and production started in late August of that year."),
        Car("1",
            "Toyota C-HR",
            "https://upload.wikimedia.org/wikipedia/commons/5/55/2017_Toyota_C-HR_%28NGX10R%29_Koba_2WD_hatchback_%282018-08-06%29_01.jpg",
            2017,
            "Toyota",
            HYBRID,
            "The Toyota C-HR is a subcompact crossover SUV produced by Toyota. The production version of the C-HR was unveiled at the March 2016 Geneva Motor Show.")
    )

    companion object {
        val instance: CarRepositoryInterface = CarRepository()
    }

    private var currentCar: Car? = null

    override val selectedCar: Car?
        get() = currentCar

    /**
     * Busca a lista de carros a ser exibida na View.
     * @param callback usado para receber a lista de carros buscada.
     */
    override fun fetch(callback: (List<Car>) -> Unit) {
        callback(simplifiedCars)
    }

    /**
     * Busca os detalhes de um carro a ser exibida na View.
     * @param id identificador do carro.
     * @param callback usado para receber o carro buscado.
     */
    override fun fetch(id: String, callback: (Car) -> Unit) {
        val car = cars.first { it.id == id }
        currentCar = car
        callback(car)
    }
}