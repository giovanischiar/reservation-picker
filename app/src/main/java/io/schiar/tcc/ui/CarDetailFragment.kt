package io.schiar.tcc.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import io.schiar.tcc.R

class CarDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_detail, container, false)
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
            val navId = R.id.fragment_car_detail_to_fragment_reservation_options
            Navigation.findNavController(view ?: return false).navigate(navId)
            true
        } else super.onOptionsItemSelected(item)

    }

}
