package com.example.hahaj.hw1bykt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

//버튼 리스너는 2가지 방법을 이용해서 구현
// 1. 가상 버튼 리스너
// 2. 클래스형 버튼 리스너

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listener1 = BtnListener1()
        btn1.setOnClickListener { listener1 }

        var listener2 = BtnListener2()
        btn2.setOnClickListener { listener2 }

        var listener3 = BtnListener3()
        btn3.setOnClickListener { listener3 }
        btn4.setOnClickListener { listener3 }

        //람다식 사용
        btn5.setOnClickListener { view->
            textView.text="다섯번째 버튼을 누름"

        }
        btn6.setOnClickListener { view->
            textView.text="여섯번째 버튼을 누름"
        }

        var listener4 = View.OnClickListener { view ->
            when(view.id) {
                R.id.btn7 -> textView.text = "일곱번째 버튼을 누름"
                R.id.btn8 -> textView.text = "여덟번째 버튼을 누름"
            }
        }

        btn7.setOnClickListener(listener4)
        btn8.setOnClickListener(listener4)
    }

    inner class BtnListener1: View.OnClickListener{ //인터페이스 상속
        override fun onClick(v: View?) {
            textView.text="첫번째 버튼을 누름"
        }
    }

    inner class BtnListener2: View.OnClickListener{ //인터페이스 상속
        override fun onClick(v: View?) {
            textView.text="두번째 버튼을 누름"
        }
    }
    //하나의 listener에서 여러 버튼 처리
    inner class BtnListener3: View.OnClickListener{
        override fun onClick(v: View?) {

            //버튼에 따라 다르게 처리
            when(v?.id){
                R.id.btn3 -> textView.text = "세 번째 버튼을 누름"
                R.id.btn4 -> textView.text = "네 번째 버튼을 누름"
            }
        }
    }
}
