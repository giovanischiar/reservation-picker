package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import io.schiar.tcc.R
import io.schiar.tcc.viewmodel.HotelViewModel
import io.schiar.tcc.viewmodel.Preview
import kotlinx.android.synthetic.main.fragment_hotels.view.*

class HotelsFragment : Fragment(), OnClickPreviewListener {

    private lateinit var viewModel: HotelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotels, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val hotelViewClass = HotelViewModel::class.java
        viewModel = ViewModelProviders.of(requireActivity()).get(hotelViewClass)
        viewModel.hotels.observe(this, Observer { onPreviewsListChange(it) })
        viewModel.fetch()
    }

    private fun onPreviewsListChange(previews: List<Preview>) {
        val view = view ?: return
        view.hotels_list.adapter = PreviewAdapter(previews, requireContext(), this)
    }

    override fun onPreviewClick(index: Int, view: View) {
        viewModel.fetch(index)
        val navId = R.id.fragment_hotels_to_fragment_hotel_detail
        Navigation.findNavController(view).navigate(navId)
    }
}
