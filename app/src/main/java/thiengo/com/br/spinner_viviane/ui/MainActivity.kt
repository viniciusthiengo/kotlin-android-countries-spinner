package thiengo.com.br.spinner_viviane.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import thiengo.com.br.spinner_viviane.R

/**
 * Atividade principal do projeto.
 *
 * O rótulo [MainActivity] é opcional, pode ser alterado para
 * qualquer outro. Mas por convenção espera-se que o rótulo
 * de uma atividade termine sempre com o termo Activity.
 */
class MainActivity : AppCompatActivity() {

    companion object{
        /**
         * Constante responsável por manter o fragmento recém
         * criado em memória.
         */
        private const val FRAG_KEY = "fragment_key"
    }

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        setFragment()
    }

    /**
     * Coloco o fragmento em tela, dentro da atividade principal.
     * Tendo como container o layout da atividade principal.
     */
    private fun setFragment(){
        val fragTransaction = supportFragmentManager.beginTransaction()

        fragTransaction.replace(
            R.id.ll_fragment_container,
            getFragment(),
            FRAG_KEY
        )

        fragTransaction.commit()
    }

    /**
     * Método responsável por verificar se o fragmento já está na
     * memória.
     *
     * Caso sim, está na memória, então não crie um novo, apenas
     * reutilize o fragmento em memória.
     *
     * Desta forma as chances de problemas de lentidão e de
     * vazamento de memória são bem menores.
     */
    private fun getFragment() : Fragment {
        var fragment = supportFragmentManager.findFragmentByTag( FRAG_KEY )

        if( fragment == null ){
            fragment = CountriesFragment()
        }

        return fragment
    }
}