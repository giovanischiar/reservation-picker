package io.schiar.tcc.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import io.schiar.tcc.R
import android.view.MenuInflater
import androidx.navigation.Navigation

class HotelDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel_detail, container, false)
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
            val navId = R.id.fragment_hotel_detail_to_fragment_adults_children
            Navigation.findNavController(view ?: return false).navigate(navId)
            true
        } else super.onOptionsItemSelected(item)

    }
}
