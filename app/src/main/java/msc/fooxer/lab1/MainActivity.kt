package msc.fooxer.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import java.util.ArrayList

class Item (var number: String)
internal var items: MutableList<Item> = ArrayList()
internal var converter = Converter()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setItems()
        val recyclerView = findViewById <RecyclerView> (R.id.list)
        val adapter = MyAdapter(this, items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun setItems () {
    for (i in 0 .. 999999)
        items.add(Item(converter.numInWord(i+1)))
    }
}