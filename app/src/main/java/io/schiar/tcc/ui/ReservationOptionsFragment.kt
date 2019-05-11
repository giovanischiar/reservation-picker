package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import io.schiar.tcc.R
import kotlinx.android.synthetic.main.fragment_reservation_options.view.*

/**
 * Fragmento da tela de escolha de reservas.
 */
class ReservationOptionsFragment : Fragment() {

    /**
     * São definidos os listeners dos botões da view. Cada botão ativa uma transição do navigation para outro fragmento.
     * @param inflater usado para carregar o XML do fragmento.
     * @param container o componente pai do fragmento.
     * @param savedInstanceState dados do estado anterior do fragmento.
     * @return view correspondente ao fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reservation_options, container, false)
        view.reservation_btn.setOnClickListener {
            val navId = R.id.fragment_reservation_options_to_fragment_reservation
            Navigation.findNavController(view).navigate(navId)
        }

        view.cars_btn.setOnClickListener {
            val navId = R.id.fragment_reservation_options_to_fragment_cars
            Navigation.findNavController(view).navigate(navId)
        }

        view.hotels_btn.setOnClickListener {
            val navId = R.id.fragment_reservation_options_to_fragment_hotels
            Navigation.findNavController(view).navigate(navId)
        }
        return view
    }

}
