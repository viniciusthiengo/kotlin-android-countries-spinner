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

/**
 * Fragmento principal em projeto. Responsável também por
 * conter o layout de conteúdo, layout com o [Spinner] e
 * o [TextView].
 *
 * A implementação da Interface [AdapterView.OnItemSelectedListener]
 * se faz necessária para que seja possível colocar um
 * ouvidor (listener) de mudança de item no [Spinner]
 * principal em layout.
 *
 * A partir desse ouvidor configurado é possível acionar
 * outras mudanças em app em tempo de execução.
 */
class CountriesFragment : Fragment(), AdapterView.OnItemSelectedListener {

    companion object{
        /**
         * Como em mais de um ponto da lógica de negócio do
         * fragmento [CountriesFragment] é necessária uma
         * [String] vazia (""), então foi prudente colocar
         * esse valor de [String] vazia em uma constatnte
         * privada dentro do fragmento.
         */
        private const val EMPTY_STRING = ""
    }

    /**
     * [countries] esta como uma propriedade de objeto, pois
     * está lista será acessada em vários pontos de
     * [CountriesFragment] e não somente em um único método.
     */
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

    /**
     * A inicialização e configuração dos componentes visuais
     * se inicia em onActivityCreated(), pois assim é possível
     * utilizar o ID de cada componente visual com a sintaxe
     * do plugin kotlin-android-extensions (plugin configurado
     * no Gradle Nível de Aplicativo).
     */
    override fun onActivityCreated( savedInstanceState: Bundle? ) {
        super.onActivityCreated( savedInstanceState )

        fillCountriesList()
        configCountrySpinner()
    }

    /**
     * Método responsável por preencher a lista [countries]
     * que será a lista vinculada ao [Spinner] principal em
     * tela.
     *
     * Se o código for reaproveitado, é exatamente a lista
     * [countries] que deve receber os dados do banco de dados.
     */
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

    /**
     * Método responsável por criar toda a configuração
     * inicial do principal [Spinner] em tela.
     *
     * 1º passo - O adapter é criado;
     *
     * 2º passo - O adapter é vinculado ao [Spinner]
     * [sp_countries];
     *
     * 3º passo - O ouvidor (listener) de mudança de item
     * em [Spinner] é vinculado ao [Spinner] principal.
     */
    private fun configCountrySpinner(){
        // 1º passo.
        val countriesAdapter = CountriesAdapter(
            /**
             * Force NullPointerException (!!) é necessário
             * aqui, pois [CountriesAdapter] não aceita null
             * como primeiro parâmetro do construtor e
             * [activity] pode sim ser null (mesmo que
             * utópico tendo em mente o fluxo do código
             * deste projeto).
             */
            activity!!,
            countries
        )

        // 2º passo.
        sp_countries.adapter = countriesAdapter

        // 3º passo.
        sp_countries.onItemSelectedListener = this
    }

    /**
     * onItemSelected() é um dos dois métodos obrigatórios
     * de implementação quando se implementa a Interface
     * [AdapterView.OnItemSelectedListener].
     *
     * A lógica de negócio deste método é responsável por
     * atualizar o [TextView] de conteúdo em tela. [TextView]
     * de ID [tv_selected_state].
     *
     * Algum texto somente será mostrado em tela se a
     * propriedade [info], do objeto de tipo [Country], não
     * estiver vazia. Caso contrário nada é apresentado,
     * pois foi a primeira opção a opção selecionada. A
     * primeira opção não é uma opção válida segundo as
     * regras de negócio deste projeto.
     */
    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
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

    /**
     * onNothingSelected() é um dos dois métodos obrigatórios
     * de implementação quando se implementa a Interface
     * [AdapterView.OnItemSelectedListener]. Aqui este método
     * não tem utilidade, assim, mantenha-o vazio.
     */
    override fun onNothingSelected( parent: AdapterView<*>? ) {}
}