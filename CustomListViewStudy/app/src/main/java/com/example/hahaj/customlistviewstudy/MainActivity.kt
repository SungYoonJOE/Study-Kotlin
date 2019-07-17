package com.example.hahaj.customlistviewstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var data = arrayOf("data1", "data2", "data3", "data4", "data5", "data6")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        그냥 항목을 터치한 후 이벤트를 사용하겠다 -> SimpleAdapter 사용
        버튼을 누르면 뭔가를 처리하는 기능(특별한 기능 추가) -> Adapter 만들어 사용
*/
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
            //매개변수로 들어온 것의 객체 반환. 필요업을 땐 null반환
            return null
        }

        override fun getItemId(position: Int): Long {
            //항목의 id반환
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? { //?가 있고 없고 차이..
            /*
            항목 하나를 구성하기 위해 호출되는 메소드

            전에 보였다가 안 보이는 뷰는 버리지 않고 p1으로 넘어옴. 재사용!
            몇 개의 뷰를 가지고 무한대로 사용 가능
            */

            //var convertView:View? = null
            var convertView2:View? = convertView //재사용 가능한 뷰가 있을 경우

            if(convertView == null){ //재사용 가능한 뷰가 없을 경우
                convertView2 = layoutInflater.inflate(R.layout.row, null) //뷰를 만들어줌
            }

            var text:TextView? = convertView2?.findViewById<TextView>(R.id.textView2)

            var button1:Button? = convertView2?.findViewById<Button>(R.id.button1)
            var button2:Button? = convertView2?.findViewById<Button>(R.id.button2)

            text?.text = data[position]
            button1?.setOnClickListener { listener}
            button2?.setOnClickListener { listener}

            button1?.tag = position
            button2?.tag = position

            return convertView2
        }
    }

    inner class BtnListener : View.OnClickListener{
        //lambda식으로 해도 되지만 객체 하나만 만들어서 계속 사용해서 메모리를 아끼는 방식 선택
        override fun onClick(v: View?) {
            //button값으로 분기
            var pos = v?.tag as Int

            when(v?.id){
                R.id.button1 -> {
                    textView.text = "${pos+1}번째 항목의 첫번째 버튼을 눌렀습니다."
                    Log.i("TAG","${pos+1}")
                }
                R.id.button2 ->
                    textView.text = "${pos+1}번째 항목의 두번째 버튼을 눌렀습니다."
            }
        }
    }
}
