package io.schiar.tcc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.archit.calendardaterangepicker.customviews.DateRangeCalendarView

import io.schiar.tcc.R
import kotlinx.android.synthetic.main.fragment_date_range.view.*
import java.util.*

class DateRangeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_date_range, container, false)
        view.ok_btn.setOnClickListener {
            val navId = R.id.fragment_date_range_to_fragment_reservation_options
            Navigation.findNavController(view).navigate(navId)
        }
        return view
    }

}
