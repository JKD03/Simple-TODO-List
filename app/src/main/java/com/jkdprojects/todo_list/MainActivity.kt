package com.jkdprojects.todo_list

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.jkdprojects.todo_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding : ActivityMainBinding
    var itemlist = ArrayList<String>()
    var filehelper = Filehelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding=ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        itemlist =  filehelper.readData(this)
        var arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, R.id.text1,itemlist)

        mainBinding.list.adapter = arrayAdapter

        mainBinding.button.setOnClickListener {
            var itemname : String = mainBinding.itemname.text.toString()
            itemlist.add(itemname)
            mainBinding.itemname.setText("")
            filehelper.writeData(itemlist,applicationContext)
            arrayAdapter.notifyDataSetChanged()
        }

    }
}