package io.schiar.tcc.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import io.schiar.tcc.R
import io.schiar.tcc.viewmodel.CarViewModel
import io.schiar.tcc.viewmodel.Preview
import kotlinx.android.synthetic.main.fragment_cars.view.*

/**
 * Fragmento que mostra a lista de carros disponíveis para reserva.
 * @property viewModel ViewModel necessário para mostrar os dados necessários do modelo na View.
 */
class CarsFragment : Fragment(), OnClickPreviewListener {

    private lateinit var viewModel: CarViewModel

    /**
     * Carrega do XML a View que representa o fragmento.
     * @param inflater usado para carregar o XML do fragmento.
     * @param container o componente pai do fragmento.
     * @param savedInstanceState dados do estado anterior do fragmento.
     * @return view correspondente ao fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cars, container, false)
    }

    /**
     * É carregado o [CarViewModel] para passar ao databinding do XML, assim o XML tem acesso aos atributos e métodos.
     * do ViewModel. Busca-se a lista de carros do ViewModel.
     * @param savedInstanceState dados do estado anterior do fragmento.
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val carViewModelClass = CarViewModel::class.java
        viewModel = ViewModelProviders.of(requireActivity()).get(carViewModelClass)
        viewModel.cars.observe(this, Observer { onPreviewsListChange(it) })
        viewModel.fetch()
    }

    /**
     * Observador das mudanças da lista de carros, definição do Adapter responsável para configuração da lista.
     * @param previews lista simplificada dos dados dos carros.
     */
    private fun onPreviewsListChange(previews: List<Preview>) {
        val view = view ?: return
        view.cars_list.adapter = PreviewAdapter(previews, requireContext(), this)
    }

    /**
     * Ao clicar em um carro, navegue até o framento de detalhes.
     * @param index índice do carro.
     * @param view view que representa um item da lista de carros.
     */
    override fun onPreviewClick(index: Int, view: View) {
        viewModel.fetch(index)
        val navId = R.id.fragment_cars_to_fragment_car_detail
        Navigation.findNavController(view).navigate(navId)
    }

}
