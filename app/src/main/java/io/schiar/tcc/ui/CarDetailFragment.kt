package io.schiar.tcc.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import io.schiar.tcc.R
import io.schiar.tcc.databinding.FragmentCarDetailBinding
import io.schiar.tcc.viewmodel.CarViewModel
import io.schiar.tcc.viewmodel.TripViewModel

/**
 * Fragmento que mostra os detalhes de um carro.
 * @property viewModel ViewModel necessário para mostrar os dados necessários do modelo na View
 * @property tripViewModel ViewModel necessário para atualizar os dados da viagem no modelo
 */
class CarDetailFragment : Fragment() {

    private lateinit var viewModel: CarViewModel
    private lateinit var tripViewModel: TripViewModel

    /**
     * É carregado o [CarViewModel] e o [TripViewModel] para passar ao databinding do XML, assim o XML tem acesso aos
     * atributos e métodos do ViewModel.
     * @param inflater usado para carregar o XML do fragmento.
     * @param container o componente pai do fragmento.
     * @param savedInstanceState dados do estado anterior do fragmento.
     * @return view correspondente ao fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val carViewClass = CarViewModel::class.java
        val tripViewClass = TripViewModel::class.java
        viewModel = ViewModelProviders.of(requireActivity()).get(carViewClass)
        tripViewModel = ViewModelProviders.of(requireActivity()).get(tripViewClass)
        val binding = FragmentCarDetailBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@CarDetailFragment
            viewModel = this@CarDetailFragment.viewModel
            executePendingBindings()
        }
        return binding.root
    }

    /**
     * Avisa a atividade que há opções de menu na barra superior.
     *  @param savedInstanceState dados do estado anterior do fragmento.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    /**
     * Carrega o componente de menu que irá ser mostrado na barra superior.
     * @param menu componente de menu.
     * @param inflater carregador do XML.
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    /**
     * Ao clicar na opção de menu "escolher" adiciona o carro a reserva e navegue para [ReservationOptionsFragment].
     * @param item o item de menu selecionado.
     * @return true se foi selecionado com sucesso, false caso contrário.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.choose_opt) {
            Toast.makeText(requireContext(), resources.getText(R.string.reserved), Toast.LENGTH_LONG).show()
            tripViewModel.addCarToTrip()
            val navId = R.id.fragment_car_detail_to_fragment_reservation_options
            Navigation.findNavController(view ?: return false).navigate(navId)
            true
        } else super.onOptionsItemSelected(item)
    }
}
