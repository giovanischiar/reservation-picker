package io.schiar.tcc.model.repository

import io.schiar.tcc.model.Hotel

/**
 * Contrato de um fornecedor de dados para a aplicação.
 * O padrão repository proporciona uma abstração da camada de dados da aplicação.
 * Além disso, ele centraliza o uso dos objetos do domínio.
 * Através de um repository, outros componentes da aplicação conseguem
 * manejar os objetos do domínio de forma simples, sem precisar
 * conhecer de fato de onde esses objetos vêm e onde são armazenados (internet, banco de dados, caches, etc).
 * Isso permite que todos os componentes que usam o repository possuam um baixo
 * acomplamento com as camadas de serviço e persistência da aplicação.
 *
 * @property selectedHotel hotel atual selecionado.
 */
interface HotelRepositoryInterface {
    val selectedHotel: Hotel?

    /**
     * Busca a lista de hotéis a ser exibida na View.
     * @param callback usado para receber a lista de hotéis buscada.
     */
    fun fetch(callback: (List<Hotel>) -> Unit)

    /**
     * Busca os detalhes de um hotel a ser exibido na View.
     * @param id identificador do hotel.
     * @param callback usado para receber o hotel buscado.
     */
    fun fetch(id: String, callback: (Hotel) -> Unit)
}