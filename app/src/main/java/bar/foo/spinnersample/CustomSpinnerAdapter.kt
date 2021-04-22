package bar.foo.spinnersample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomSpinnerAdapter(val context: Context, var dataSource: List<CustomSpinnerHolder>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //region SpinnerAdapter

    /**
     * Gets a View that displays in the drop down popup the data at the specified position in the data set.
     */
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.spinner_artist_dropdown, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        vh.label.text = dataSource.get(position).name

        return view
    }

    //endregion

    //region Adapter

    /**
     * How many items are in the data set represented by this Adapter.
     */
    override fun getCount(): Int {
        return dataSource.size;
    }

    /**
     * Get the data item associated with the specified position in the data set.
     */
    override fun getItem(position: Int): Any? {
        return dataSource[position];
    }

    /**
     * Get the row id associated with the specified position in the list.
     */
    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    /**
     * Get a View that displays the data at the specified position in the data set.
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: SelectedItemHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.spinner_artist, parent, false)
            vh = SelectedItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as SelectedItemHolder
        }
        vh.label.text = dataSource.get(position).shortName

        return view
    }

    //endregion

    //region PRIVATE CLASS

    private class SelectedItemHolder(row: View?) {
        val label: TextView

        init {
            label = row?.findViewById(R.id.custom_spinner_short_name) as TextView
        }
    }

    private class ItemHolder(row: View?) {
        val label: TextView

        init {
            label = row?.findViewById(R.id.custom_spinner_name) as TextView
        }
    }

    //endregion
}