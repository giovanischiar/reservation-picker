package io.schiar.tcc.ui

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.archit.calendardaterangepicker.customviews.DateRangeCalendarView

import io.schiar.tcc.R
import io.schiar.tcc.viewmodel.TripViewModel
import kotlinx.android.synthetic.main.fragment_date_range.view.*
import java.util.*

class DateRangeFragment : Fragment(), DateRangeCalendarView.CalendarListener {

    private lateinit var viewModel: TripViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val tripViewClass = TripViewModel::class.java
        viewModel = ViewModelProviders.of(requireActivity()).get(tripViewClass)
        val view = inflater.inflate(R.layout.fragment_date_range, container, false)
        view.ok_btn.setOnClickListener {
            val navId = R.id.fragment_date_range_to_fragment_reservation_options
            Navigation.findNavController(view).navigate(navId)
        }
        view.calendar.setCalendarListener(this)
        return view
    }

    override fun onDateRangeSelected(startDate: Calendar?, endDate: Calendar?) {
        startDate ?: return; endDate ?: return
        viewModel.addPeriodToTrip(startDate.timeInMillis, endDate.timeInMillis)
    }

    override fun onFirstDateSelected(startDate: Calendar?) {}

}
