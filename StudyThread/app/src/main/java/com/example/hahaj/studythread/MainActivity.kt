package com.example.hahaj.studythread

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view->
            var now = System.currentTimeMillis()
            textView.text = "버튼 클릭 : ${now}"
        }
        /*
        while(true){
            var now = System.currentTimeMillis()
            textView2.text = "무한루프 : ${now}"
        }
        */

        isRunning = true
        var thread = ThreadClass1()
        thread.start()
    }

    inner class ThreadClass1 : Thread(){
        override fun run() {
            while (isRunning) {
                SystemClock.sleep(100)
                var now = System.currentTimeMillis()
                Log.d("test1", "쓰레드 : ${now}")

                textView2.text = "쓰레드 : ${now}" //8.0부터 가능.
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}
