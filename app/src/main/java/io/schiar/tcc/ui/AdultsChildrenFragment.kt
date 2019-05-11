package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import io.schiar.tcc.R
import io.schiar.tcc.databinding.FragmentAdultsChildrenBinding
import io.schiar.tcc.viewmodel.TripViewModel
import kotlinx.android.synthetic.main.fragment_adults_children.view.*

/**
 * Fragmento que se define quantos adultos e quantas crianças são incluídas na reserva.
 * @property viewModel ViewModel necessário para mostrar os dados necessários do modelo na View
 */
class AdultsChildrenFragment : Fragment() {

    private lateinit var viewModel: TripViewModel

    /**
     * É carregado o [TripViewModel] para passar ao databinding do XML, assim o XML tem acesso aos atributos e métodos.
     * do ViewModel. Define listener para navegação ao fragmento [ReservationFragment]
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
        val binding = FragmentAdultsChildrenBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@AdultsChildrenFragment
            viewModel = this@AdultsChildrenFragment.viewModel
            executePendingBindings()
        }
        val view = binding.root

        view.reserve_hotel_btn.setOnClickListener {
            Toast.makeText(requireContext(), resources.getText(R.string.reserved), Toast.LENGTH_LONG).show()
            val navId = R.id.fragment_adults_children_to_fragment_reservation_options
            Navigation.findNavController(view).navigate(navId)
        }
        return view
    }

}
