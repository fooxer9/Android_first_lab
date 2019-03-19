package msc.fooxer.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.ArrayList

class Item (var number: String)
internal var items: MutableList<Item> = ArrayList()
internal var converter = Converter()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
