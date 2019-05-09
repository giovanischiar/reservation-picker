package io.schiar.tcc.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import io.schiar.tcc.R
import kotlinx.android.synthetic.main.fragment_cars.view.*
import kotlinx.android.synthetic.main.fragment_hotels.view.*

class HotelsFragment : Fragment(), OnClickPreviewListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hotels, container, false)

        val hotels = listOf(
            Preview(BitmapFactory.decodeResource(resources, R.drawable.hotel), "Marriott Sunnyvale Residence Inn"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.hotel), "Marriott Sunnyvale Residence Inn"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.hotel), "Marriott Sunnyvale Residence Inn"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.hotel), "Marriott Sunnyvale Residence Inn"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.hotel), "Marriott Sunnyvale Residence Inn"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.hotel), "Marriott Sunnyvale Residence Inn"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.hotel), "Marriott Sunnyvale Residence Inn"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.hotel), "Marriott Sunnyvale Residence Inn"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.hotel), "Marriott Sunnyvale Residence Inn"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.hotel), "Marriott Sunnyvale Residence Inn")
        )
        view.hotels_list.adapter = PreviewAdapter(hotels, requireContext(), this)
        return view
    }

    override fun onPreviewClick(index: Int, view: View) {
        val navId = R.id.fragment_hotels_to_fragment_hotel_detail
        Navigation.findNavController(view).navigate(navId)
    }

}
