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

class CarsFragment : Fragment(), OnClickPreviewListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cars, container, false)

        val cars = listOf(
            Preview(BitmapFactory.decodeResource(resources, R.drawable.car), "Jeep Renegade"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.car), "Jeep Renegade"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.car), "Jeep Renegade"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.car), "Jeep Renegade"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.car), "Jeep Renegade"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.car), "Jeep Renegade"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.car), "Jeep Renegade"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.car), "Jeep Renegade"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.car), "Jeep Renegade"),
            Preview(BitmapFactory.decodeResource(resources, R.drawable.car), "Jeep Renegade")
            )
        view.cars_list.adapter = PreviewAdapter(cars, requireContext(), this)
        return view
    }

    override fun onPreviewClick(index: Int, view: View) {
        val navId = R.id.fragment_cars_to_fragment_car_detail
        Navigation.findNavController(view).navigate(navId)
    }

}
