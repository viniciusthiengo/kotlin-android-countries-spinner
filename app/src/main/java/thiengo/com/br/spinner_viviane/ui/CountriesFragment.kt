package thiengo.com.br.spinner_viviane.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import kotlinx.android.synthetic.main.fragment_countries.*
import thiengo.com.br.spinner_viviane.R
import thiengo.com.br.spinner_viviane.model.Country

class CountriesFragment : Fragment(), AdapterView.OnItemSelectedListener {

    companion object{
        const val EMPTY_STRING = ""
    }

    private val countries = mutableListOf<Country>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(
            R.layout.fragment_countries,
            container,
            false
        )
    }

    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )
        fillCountriesList()
        configCountrySpinner()
    }

    private fun fillCountriesList(){
        countries.addAll(
            mutableListOf(
                Country(
                    id = 0,
                    name = getString(R.string.select_an_option),
                    image = 0,
                    info = EMPTY_STRING
                ),
                Country(
                    id = 1,
                    name = getString(R.string.argentina),
                    image = R.drawable.ic_flag_argentina,
                    info = getString(R.string.argentina_info)
                ),
                Country(
                    id = 2,
                    name = getString(R.string.brazil),
                    image = R.drawable.ic_flag_brazil,
                    info = getString(R.string.brazil_info)
                ),
                Country(
                    id = 3,
                    name = getString(R.string.south_korea),
                    image = R.drawable.ic_flag_south_korea,
                    info = getString(R.string.south_korea_info)
                ),
                Country(
                    id = 4,
                    name = getString(R.string.united_states),
                    image = R.drawable.ic_flag_united_states_of_america,
                    info = getString(R.string.united_states_info)
                )
            )
        )
    }

    private fun configCountrySpinner(){
        val countriesAdapter = CountriesAdapter(
            activity!!,
            countries
        )

        sp_countries.adapter = countriesAdapter
        sp_countries.onItemSelectedListener = this
    }

    override fun onItemSelected(
        parent: AdapterView<*>,
        view: View,
        position: Int,
        id: Long ) {

        if( countries[ position ].info.isEmpty() ){
            tv_selected_state.text = EMPTY_STRING
        }
        else{
            tv_selected_state.text = String.format(
                getString(R.string.info_template),
                countries[ position ].name,
                countries[ position ].info
            )
        }
    }

    override fun onNothingSelected( parent: AdapterView<*>? ) {}
}