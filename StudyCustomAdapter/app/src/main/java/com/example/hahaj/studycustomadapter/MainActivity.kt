package com.example.hahaj.studycustomadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("데이터1","데이터2","데이터3","데이터4","데이터5","데이터6")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //리스트뷰 항목 하나에 데이터가 2개 이상이면 Simple사용하면 됨
        //var adapter = ArrayAdapter<String>(this, R.layout.row, R.id.textView2, data)
        var adapter = ListAdapter()
        listView.adapter = adapter
    }
    inner class ListAdapter: BaseAdapter(){

        var listener = BtnListener()

        override fun getCount(): Int {
            //리스트뷰 항목의 개수 반환
            return data.size
        }

        override fun getItem(position: Int): Any? {
            //객체를 반환하고 싶을 때 (필요없을 경우 null반환)
            return null
        }

        override fun getItemId(position: Int): Long {
            //항목을 대표하는 ID 반환
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            /* 항목 하나를 구성하기 위해 호출됨
            * 항목이 많을 경우 스크롤 생성 안보이던 항목이 보이게 됨
            * 100개이지만 현재 화면에 7개 보일 경우 getView()가 7번 실행
            * 보이던 항목이 안 보이는 경우도 존재 버리는게 아니라 두번째 매개변수(convertView: View?)로 넘어가서 재사용함
            * -> 몇 개의 뷰객체만을 가지고 무한개의 리스트뷰 항목을 갖고 있게 됨
            * 재사용 가능한 뷰가 넘어오지 않으면 convertView: View?에 null값이 넘어감
            */
            var convertView2:View? = convertView //재사용 가능한 뷰가 넘어왔을 경우 재사용! 없을 경우 아래 코드로 이동

            if(convertView == null){ // convertView: View 재사용한 뷰가 널값이라면 재사용한 뷰가 없다는 의미
                convertView2 = layoutInflater.inflate(R.layout.row, null) //만들어주면 됨
            }

            var text:TextView? = convertView2?.findViewById<TextView>(R.id.textView2)

            var button1:Button? = convertView2?.findViewById<Button>(R.id.button1)
            var button2:Button? = convertView2?.findViewById<Button>(R.id.button2)

            text?.text = data[position]
            button1?.setOnClickListener(listener)
            button2?.setOnClickListener(listener)

            //버튼에 한 항목의 태그 값을 저장
            button1?.tag = position
            button2?.tag = position
            return convertView2
        }
    }

    inner class BtnListener:View.OnClickListener{
        //모든 버튼 처리 람다식도 되지만 객체 하나를 가지고 사용해서 메모리를 절약
        override fun onClick(v: View?) { //버튼을 누르면 객체 v: View? 들어감
            var pos = v?.tag as Int
            when(v?.id){
                R.id.button1 ->{
                    textView.text = "첫 번째 버튼을 눌렀습니다\n"
                    textView.append("${pos} 번째 항목")}
                R.id.button2 ->
                    textView.text = "${pos+1} 번째 항목: 두 번째 버튼을 눌렀습니다"
            }
        }
    }
}
