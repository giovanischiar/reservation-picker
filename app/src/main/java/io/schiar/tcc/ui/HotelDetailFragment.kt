package io.schiar.tcc.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import io.schiar.tcc.R
import io.schiar.tcc.databinding.FragmentHotelDetailBinding
import io.schiar.tcc.viewmodel.HotelViewModel
import io.schiar.tcc.viewmodel.TripViewModel
import kotlinx.android.synthetic.main.fragment_hotel_detail.*
import kotlinx.android.synthetic.main.fragment_hotel_detail.view.*

/**
 * Fragmento que mostra os detalhes de um hotel.
 * @property viewModel ViewModel necessário para mostrar os dados necessários do modelo na View
 * @property tripViewModel ViewModel necessário para mostrar os dados necessários do modelo na View
 */
class HotelDetailFragment : Fragment() {

    private lateinit var viewModel: HotelViewModel
    private lateinit var tripViewModel: TripViewModel

    /**
     * É carregado o [HotelViewModel] e o [TripViewModel] para passar ao databinding do XML, assim o XML tem acesso aos
     * atributos e métodos do ViewModel. Define os fragmentos e títulos para exibir contato e amenidades de um hotel.
     * @param inflater usado para carregar o XML do fragmento.
     * @param container o componente pai do fragmento.
     * @param savedInstanceState dados do estado anterior do fragmento.
     * @return view correspondente ao fragmento.
     */
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

    /**
     * Avisa a atividade que há opções de menu na barra superior.
     *  @param savedInstanceState dados do estado anterior do fragmento.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    /**
     * Carrega o componente de menu que irá ser mostrado na barra superior.
     * @param menu componente de menu.
     * @param inflater carregador do XML.
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    /**
     * Ao clicar na opção de menu "escolher" adiciona o hotél a reserva e navegue para [AdultsChildrenFragment].
     * @param item o item de menu selecionado.
     * @return true se foi selecionado com sucesso, false caso contrário.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.choose_opt) {
            tripViewModel.addHotelToTrip()
            val navId = R.id.fragment_hotel_detail_to_fragment_adults_children
            Navigation.findNavController(view ?: return false).navigate(navId)
            true
        } else super.onOptionsItemSelected(item)

    }

    /**
     * Responsável pela configuração das abas.
     * @property listFragments lista dos fragmentos das abas.
     * @property listFragmentsTitle lista dos títulos dos fragmentos das abas.
     */
    inner class TabsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val listFragments = mutableListOf<Fragment>()
        private val listFragmentsTitle = mutableListOf<String>()

        /**
         * Adiciona na View o fragmento da aba.
         * @param frag o fragmento a ser adicionado.
         * @param title o título do fragmento a ser adicionado.
         */
        fun add(frag: Fragment, title: String) {
            this.listFragments.add(frag)
            this.listFragmentsTitle.add(title)
        }

        /**
         * Framento definido pela posição.
         * @param position posição do fragmento.
         * @return fragmento da posição definida.
         */
        override fun getItem(position: Int): Fragment {
            return listFragments[position]
        }

        /**
         * Quantidade de fragmentos
         * @return quantidade de fragmentos
         */
        override fun getCount(): Int {
            return listFragments.size
        }

        /**
         * Título do fragmento definido pela posição.
         * @param position posição do framgmento.
         * @return título do fragmento da posição definida.
         */
        override fun getPageTitle(position: Int): CharSequence? {
            return listFragmentsTitle[position]
        }
    }

}
