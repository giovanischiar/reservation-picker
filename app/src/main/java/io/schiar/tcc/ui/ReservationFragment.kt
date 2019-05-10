package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import io.schiar.tcc.databinding.FragmentReservationBinding
import io.schiar.tcc.viewmodel.TripViewModel

class ReservationFragment : Fragment() {

    private lateinit var viewModel: TripViewModel

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
