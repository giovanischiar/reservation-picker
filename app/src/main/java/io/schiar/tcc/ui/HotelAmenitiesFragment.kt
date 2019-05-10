package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import io.schiar.tcc.databinding.FragmentHotelAmenitiesBinding
import io.schiar.tcc.viewmodel.HotelViewModel

class HotelAmenitiesFragment : Fragment() {

    private lateinit var viewModel: HotelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val hotelViewClass = HotelViewModel::class.java
        viewModel = ViewModelProviders.of(requireActivity()).get(hotelViewClass)
        val binding = FragmentHotelAmenitiesBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@HotelAmenitiesFragment
            viewModel = this@HotelAmenitiesFragment.viewModel
            executePendingBindings()
        }
        return binding.root
    }


}
