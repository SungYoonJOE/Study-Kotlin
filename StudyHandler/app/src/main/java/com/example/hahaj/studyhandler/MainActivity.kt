package com.example.hahaj.studyhandler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var handler : Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view->
            var time = System.currentTimeMillis()
            textView.text = "버튼 클릭 : ${time}"
        }
        handler = Handler()
       /* while(true){
            SystemClock.sleep(100)//100ms만큼 쉼
            var time = System.currentTimeMillis()
            textView2.text = "while : ${time}"
        }*/
        var thread = ThreadClass()
        //handler?.post(thread) //안드로이드 os가 관리
        handler?.postDelayed(thread, 100) //100ms 후에 mainthread가 한가할 때 thread 처리해달라
    }
    inner class ThreadClass : Thread(){
        override fun run() {
            var time = System.currentTimeMillis()
            textView2.text = "Handler : ${time}"

            //handler?.post(this)
            handler?.postDelayed(this, 100)
        }
    }
}
