package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation

import io.schiar.tcc.R
import kotlinx.android.synthetic.main.fragment_adult_children.view.*

class AdultsChildrenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_adult_children, container, false)
        view.reserve_hotel_btn.setOnClickListener {
            Toast.makeText(requireContext(), resources.getText(R.string.reserved), Toast.LENGTH_LONG).show()
            val navId = R.id.fragment_adults_children_to_fragment_reservation_options
            Navigation.findNavController(view).navigate(navId)
        }
        return view
    }

}
