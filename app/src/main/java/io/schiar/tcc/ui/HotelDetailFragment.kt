package io.schiar.tcc.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import io.schiar.tcc.R
import android.view.MenuInflater
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import io.schiar.tcc.viewmodel.HotelViewModel
import io.schiar.tcc.databinding.FragmentHotelDetailBinding
import io.schiar.tcc.viewmodel.TripViewModel
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import io.schiar.tcc.ui.HotelDetailFragment.TabsAdapter
import kotlinx.android.synthetic.main.fragment_hotel_detail.*
import kotlinx.android.synthetic.main.fragment_hotel_detail.view.*


class HotelDetailFragment : Fragment() {

    private lateinit var viewModel: HotelViewModel
    private lateinit var tripViewModel: TripViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val hotelViewClass = HotelViewModel::class.java
        val tripViewClass = TripViewModel::class.java
        viewModel = ViewModelProviders.of(requireActivity()).get(hotelViewClass)
        tripViewModel = ViewModelProviders.of(requireActivity()).get(tripViewClass)
        val binding = FragmentHotelDetailBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@HotelDetailFragment
            viewModel = this@HotelDetailFragment.viewModel
            executePendingBindings()
        }

        val view = binding.root
        val adapter = TabsAdapter(childFragmentManager)
        adapter.add(HotelContactFragment(), resources.getString(R.string.contact))
        adapter.add(HotelAmenitiesFragment(), resources.getString(R.string.amenities))
        view.viewPager.adapter = adapter
        view.tabs.setupWithViewPager(viewPager)
        return view
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
            tripViewModel.addHotelToTrip()
            val navId = R.id.fragment_hotel_detail_to_fragment_adults_children
            Navigation.findNavController(view ?: return false).navigate(navId)
            true
        } else super.onOptionsItemSelected(item)

    }

    inner class TabsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val listFragments = mutableListOf<Fragment>()
        private val listFragmentsTitle = mutableListOf<String>()

        fun add(frag: Fragment, title: String) {
            this.listFragments.add(frag)
            this.listFragmentsTitle.add(title)
        }

        override fun getItem(position: Int): Fragment {
            return listFragments[position]
        }

        override fun getCount(): Int {
            return listFragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return listFragmentsTitle[position]
        }
    }
}
