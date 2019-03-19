package msc.fooxer.lab1

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import kotlin.math.absoluteValue

class MyAdapter  (val context: Context, private val items: List<Item>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val element = items[i]
        viewHolder.numberView.text = element.number
        val clr : String = if ((i + 1) % 2 == 0) "#CCCCCC" else "#FFFFFF"
        viewHolder.itemView.setBackgroundColor(Color.parseColor(clr))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        internal val numberView : TextView = view.findViewById<View>(R.id.num) as TextView
    }
}



