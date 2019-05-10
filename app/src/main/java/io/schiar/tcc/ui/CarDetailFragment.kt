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
import io.schiar.tcc.viewmodel.HotelViewModel
import io.schiar.tcc.viewmodel.TripViewModel

class CarDetailFragment : Fragment() {

    private lateinit var viewModel: CarViewModel
    private lateinit var tripViewModel: TripViewModel

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

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
