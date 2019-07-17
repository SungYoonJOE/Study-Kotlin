package com.example.hahaj.studyspinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data1 = arrayOf("스피너1-1", "스피너1-2","스피너1-3","스피너1-4","스피너1-5")
    var data2 = arrayOf("스피너2-1", "스피너2-2","스피너2-3","스피너2-4","스피너2-5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //레이아웃 2개 필요
        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data2)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter1
        spinner2.adapter = adapter2

        var listener = SpinnerListener()
        spinner.onItemSelectedListener = listener

        //오버라이딩 메소드가 2개이므로 람다식으로 할 수 없음 -> 익명 중첩 클래스 사용
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                textView.text = data2[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        button.setOnClickListener { view ->
            textView.text = data2[spinner2.selectedItemPosition]+"\n"
            textView.append(data1[spinner.selectedItemPosition])
        }
    }

    inner class SpinnerListener : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            //사용자가 항목을 선택했을 때
            //position: Int이 사용자가 선택한 항목
            textView.text = data1[position]
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {
            //아무 항목도 선택하지 않았을 때 (거의 사용 안 함)
        }
    }
}
