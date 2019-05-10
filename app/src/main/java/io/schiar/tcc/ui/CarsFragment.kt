package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import io.schiar.tcc.BR.viewModel

import io.schiar.tcc.R
import io.schiar.tcc.viewmodel.CarViewModel
import io.schiar.tcc.viewmodel.Preview
import kotlinx.android.synthetic.main.fragment_cars.view.*
import kotlinx.android.synthetic.main.fragment_hotels.view.*

class CarsFragment : Fragment(), OnClickPreviewListener {

    private lateinit var viewModel: CarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cars, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val hotelViewClass = CarViewModel::class.java
        viewModel = ViewModelProviders.of(requireActivity()).get(hotelViewClass)
        viewModel.cars.observe(this, Observer { onPreviewsListChange(it) })
        viewModel.fetch()
    }

    private fun onPreviewsListChange(previews: List<Preview>) {
        val view = view ?: return
        view.cars_list.adapter = PreviewAdapter(previews, requireContext(), this)
    }

    override fun onPreviewClick(index: Int, view: View) {
        viewModel.fetch(index)
        val navId = R.id.fragment_cars_to_fragment_car_detail
        Navigation.findNavController(view).navigate(navId)
    }

}
