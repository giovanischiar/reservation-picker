package io.schiar.tcc.ui

import android.os.Bundle
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

/**
 * Fragmento que mostra parte da tela de escolha de período para a reserva.
 * @property viewModel ViewModel necessário para mostrar os dados necessários do modelo na View.
 */
class DateRangeFragment : Fragment(), DateRangeCalendarView.CalendarListener {

    private lateinit var viewModel: TripViewModel

    /**
     * É carregado o [TripViewModel] para passar ao databinding do XML, assim o XML tem acesso aos atributos e métodos
     * do ViewModel. É definido o listener do botão de ok para navegar até o fragmento [ReservationFragment]. Também
     * define listener do componente de calendário.
     * @param inflater usado para carregar o XML do fragmento.
     * @param container o componente pai do fragmento.
     * @param savedInstanceState dados do estado anterior do fragmento.
     * @return view correspondente ao fragmento.
     */
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

    /**
     * Envia ao [TripViewModel] os dados de data inicial e final da reserva.
     * @param startDate data inicial da reserva.
     * @param endDate data final da reserva.
     */
    override fun onDateRangeSelected(startDate: Calendar?, endDate: Calendar?) {
        startDate ?: return; endDate ?: return
        viewModel.addPeriodToTrip(startDate.timeInMillis, endDate.timeInMillis)
    }

    override fun onFirstDateSelected(startDate: Calendar?) {}

}
