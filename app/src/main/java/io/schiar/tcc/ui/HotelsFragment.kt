package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import io.schiar.tcc.R
import io.schiar.tcc.viewmodel.HotelViewModel
import io.schiar.tcc.viewmodel.Preview
import kotlinx.android.synthetic.main.fragment_hotels.view.*

/**
 * Fragmento que mostra a lista de hotéis disponíveis para reserva.
 * @property viewModel ViewModel necessário para mostrar os dados necessários do modelo na View.
 */
class HotelsFragment : Fragment(), OnClickPreviewListener {

    private lateinit var viewModel: HotelViewModel

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
        return inflater.inflate(R.layout.fragment_hotels, container, false)
    }

    /**
     * É carregado o [HotelViewModel] para passar ao databinding do XML, assim o XML tem acesso aos atributos e métodos.
     * do ViewModel.
     * @param savedInstanceState dados do estado anterior do fragmento.
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val hotelViewClass = HotelViewModel::class.java
        viewModel = ViewModelProviders.of(requireActivity()).get(hotelViewClass)
        viewModel.hotels.observe(this, Observer { onPreviewsListChange(it) })
        viewModel.fetch()
    }

    /**
     * Observador das mudanças da lista de hotéis, definição do Adapter responsável para configuração da lista.
     * @param previews lista dos dados dos hotéis.
     */
    private fun onPreviewsListChange(previews: List<Preview>) {
        val view = view ?: return
        view.hotels_list.adapter = PreviewAdapter(previews, requireContext(), this)
    }

    /**
     * Ao clicar em um hotél, navegue até o framento de detalhes.
     * @param index índice do hotel.
     * @param view view que representa um item da lista de hotéis.
     */
    override fun onPreviewClick(index: Int, view: View) {
        viewModel.fetch(index)
        val navId = R.id.fragment_hotels_to_fragment_hotel_detail
        Navigation.findNavController(view).navigate(navId)
    }

}
