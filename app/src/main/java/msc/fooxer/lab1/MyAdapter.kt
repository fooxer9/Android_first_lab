package msc.fooxer.lab1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.Adapter

class MyAdapter  (val context: Context, private val items: List<Item>) : RecyclerView.Adapter<MyAdapter.ViewHolder>()




class ViewHolder