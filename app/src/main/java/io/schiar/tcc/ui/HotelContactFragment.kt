package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import io.schiar.tcc.databinding.FragmentHotelContactBinding
import io.schiar.tcc.viewmodel.HotelViewModel

/**
 * Fragmento que mostra parte da tela de detalhes de um Hotel. Mostra dados de contato do Hotel.
 * @property viewModel ViewModel necessário para mostrar os dados necessários do modelo na View.
 */
class HotelContactFragment : Fragment() {

    private lateinit var viewModel: HotelViewModel

    /**
     * É carregado o [HotelViewModel] para passar ao databinding do XML, assim o XML tem acesso aos atributos e métodos
     * do ViewModel.
     * @param inflater usado para carregar o XML do fragmento.
     * @param container o componente pai do fragmento.
     * @param savedInstanceState dados do estado anterior do fragmento.
     * @return view correspondente ao fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val hotelViewClass = HotelViewModel::class.java
        viewModel = ViewModelProviders.of(requireActivity()).get(hotelViewClass)
        val binding = FragmentHotelContactBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@HotelContactFragment
            viewModel = this@HotelContactFragment.viewModel
            executePendingBindings()
        }
        return binding.root
    }

}
