package com.example.hahaj.studytwolinelistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var data1 = arrayOf("문자열1", "문자열2","문자열3","문자열4","문자열5","문자열6")
    var data2 = arrayOf("str1", "str2","str3","str4","str5","str6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = ArrayList<HashMap<String, String>>()

        var idx =0
        while(idx<data1.size){
            var map = HashMap<String, String>()
            map.put("str1", data1[idx])
            map.put("str2", data2[idx])
            list.add(map)

            idx++
        }
        //android.R.layout.simple_list_item_2
        var key = arrayOf("str1", "str2") //haspmap에 데이터를 집어넣을 때 사용할 이름
        var ids = intArrayOf(android.R.id.text2) //안드로이드 OS가 가지고 있기 때문
        var adapter = SimpleAdapter(this, list, android.R.layout.simple_expandable_list_item_2, key, ids)
        //다른 방식을 사용하고 싶으면 android.R.layout.simple_expandable_list_item_2 대신 직접 만들어 사용할 것
        listView.adapter = adapter

        listView.setOnItemClickListener{ parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            textView.text = data1[position]

        }
    }
}
