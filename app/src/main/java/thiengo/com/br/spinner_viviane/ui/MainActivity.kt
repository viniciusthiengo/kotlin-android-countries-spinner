package thiengo.com.br.spinner_viviane.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import thiengo.com.br.spinner_viviane.R

class MainActivity : AppCompatActivity() {

    companion object{
        const val FRAG_KEY = "fragment_key"
    }

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        setFragment()
    }

    private fun setFragment(){
        val fragTransaction = supportFragmentManager.beginTransaction()

        fragTransaction.replace(
            R.id.ll_fragment_container,
            getFragment(),
            FRAG_KEY
        )

        fragTransaction.commit()
    }

    private fun getFragment() : Fragment {
        var fragment = supportFragmentManager.findFragmentByTag( FRAG_KEY )

        if( fragment == null ){
            fragment = CountriesFragment()
        }

        return fragment
    }
}