package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import io.schiar.tcc.R
import kotlinx.android.synthetic.main.fragment_reservation_options.view.*

class ReservationOptionsFragment : Fragment() {

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
