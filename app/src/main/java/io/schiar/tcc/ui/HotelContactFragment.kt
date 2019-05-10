package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import io.schiar.tcc.databinding.FragmentHotelContactBinding
import io.schiar.tcc.viewmodel.HotelViewModel

class HotelContactFragment : Fragment() {

    private lateinit var viewModel: HotelViewModel

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
