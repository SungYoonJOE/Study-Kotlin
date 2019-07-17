package com.example.hahaj.chapter3

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SimpleAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data1 = arrayOf("apple", "banana", "grape", "watermelon")
    var data3 = arrayOf(R.drawable.apple, R.drawable.banana, R.drawable.grape, R.drawable.watermelon)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = ArrayList<HashMap<String, String>>()

        var idx = 0
        while (idx<data1.size){
            var map = HashMap<String, String>()
            map.put("str", data1[idx])
            list.add(map)
            idx++
        }
        var key = arrayOf("str", "img")
        var ids = intArrayOf(android.R.id.text2)
        var adapter = SimpleAdapter(this, list, android.R.layout.simple_expandable_list_item_2, key, ids)

        listview.adapter = adapter
        /*listview.setOnItemClickListener { parent, view, position, id ->
            //textView.text = data1[position]
        }*/

        button.setOnClickListener { v: View? ->
            var searchImg = editText.text.toString()
            for(item in data1){
                if (searchImg == item){
                    var idx = data1.indexOf(item)
                    imageView2.setImageResource(data3[idx])
                }
                if(searchImg !in data1 ){
                    Toast.makeText(this, "찾는 과일이 없습니다.", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}
