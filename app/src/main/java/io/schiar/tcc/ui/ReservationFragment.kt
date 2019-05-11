package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import io.schiar.tcc.databinding.FragmentReservationBinding
import io.schiar.tcc.viewmodel.TripViewModel

/**
 * Fragmento que mostra a tela da última reserva.
 * @property viewModel ViewModel necessário para mostrar os dados necessários do modelo na View.
 */
class ReservationFragment : Fragment() {

    private lateinit var viewModel: TripViewModel

    /**
     * É carregado o [TripViewModel] para passar ao databinding do XML, assim o XML tem acesso aos atributos e métodos.
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
        val tripViewClass = TripViewModel::class.java
        viewModel = ViewModelProviders.of(requireActivity()).get(tripViewClass)
        val binding = FragmentReservationBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@ReservationFragment
            viewModel = this@ReservationFragment.viewModel
            executePendingBindings()
        }
        return binding.root
    }

}
