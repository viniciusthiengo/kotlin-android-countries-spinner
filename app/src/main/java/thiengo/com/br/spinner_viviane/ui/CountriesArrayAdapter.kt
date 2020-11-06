package thiengo.com.br.spinner_viviane.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import thiengo.com.br.spinner_viviane.model.Country

class CountriesArrayAdapter(
    context: Context,
    resource: Int,
    textViewResourceId: Int,
    val objects: List<Country> ): ArrayAdapter<Country>( context, resource, textViewResourceId, objects ) {

    override fun getCount(): Int {
        return objects.size
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup ): View {

        return super.getView(position, convertView, parent)
    }
}