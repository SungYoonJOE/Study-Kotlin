package com.example.hahaj.studythreadhandler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isRunning:Boolean = false
    var handler:DisplayHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view->
            var time = System.currentTimeMillis()
            textView.text = "버튼 클릭 : ${time}"
        }
        handler = DisplayHandler()

        isRunning = true
        var thread = ThreadClass()
        thread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

    inner class ThreadClass: Thread(){
        override fun run() {

            var a1 = 10
            var a2 = 20

            while(isRunning){
                var time = System.currentTimeMillis()
                Log.d("test1", "쓰레드 : ${time}")
                //textView2.text ="쓰레드 : ${time}" //화면처리는 버전 8.0이상에서만 가능
                //handler?.sendEmptyMessage(0) //메인쓰레드가 한가할 때 os가 DisplayHandler 호출
               /*
                var msg = Message()
                msg.what = 0
                msg.obj = time //객체가 들어갈 수 있음. 값을 무한정 넘길 수 있다.
                handler?.sendMessage(msg)
                */
                var msg2 = Message()
                msg2.what = 1
                msg2.arg1 = ++a1 //Int
                msg2.arg2 = ++a2 //Int
                msg2.obj = "안녕하세요" //객체
                handler?.sendMessage(msg2)
            }
        }
    }

    inner class DisplayHandler: Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)

            //var time = System.currentTimeMillis()
            //textView2.text = "Hanlder: ${time}"

            if(msg?.what == 0) {
                textView2.text = "Handler : ${msg?.obj}"
            }else if(msg?.what == 1){
                textView2.text = "${msg?.arg1}, ${msg?.arg2}, ${msg?.obj}"
            }
        }
    }

}
