package thiengo.com.br.spinner_viviane.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import thiengo.com.br.spinner_viviane.R
import thiengo.com.br.spinner_viviane.model.Country


/**
 * Classe adaptadora de itens para que seja possível utilizar
 * em [Spinner] um layout de itens customizado.
 *
 * É necessário herdar da classe [BaseAdapter].
 *
 * Mais sobre o [BaseAdapter] em: https://www.thiengo.com.br/utilizando-baseadapter-para-personalizacao-completa-da-listview
 */
class CountriesAdapter(
    private val context: Context,
    private val countries: List<Country>
): BaseAdapter() {

    override fun getCount()
        = countries.size

    override fun getItem(position: Int)
        = countries[position]

    override fun getItemId(position: Int)
        = countries[position].id

    override fun getView(
        position: Int,
        layout: View?,
        parent: ViewGroup?
    ): View {

        val auxLayout : View
        val viewHolder : ViewHolder

        if( layout == null ) {

            auxLayout = LayoutInflater.from(context)
                .inflate(
                    R.layout.country_item,
                    parent,
                    false
                )

            viewHolder = ViewHolder( auxLayout )
            auxLayout.setTag( viewHolder )
        }
        else {
            auxLayout = layout
            viewHolder = layout.tag as ViewHolder
        }

        val country = getItem( position )
        viewHolder.tvName.text = country.name
        viewHolder.ivFlag.setImageResource( country.image )
        viewHolder.tvInfo.text = country.info

        return auxLayout
    }


    private class ViewHolder( layout: View ) {
        var tvName: TextView
        var ivFlag: ImageView
        var tvInfo: TextView

        init {
            tvName = layout.findViewById(R.id.tv_name) as TextView
            ivFlag = layout.findViewById(R.id.iv_flag) as ImageView
            tvInfo = layout.findViewById(R.id.tv_info) as TextView
        }
    }
}