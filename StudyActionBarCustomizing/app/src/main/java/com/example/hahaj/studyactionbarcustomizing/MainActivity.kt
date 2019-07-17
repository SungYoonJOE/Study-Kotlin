package com.example.hahaj.studyactionbarcustomizing

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        //커스터마이징한 액션바 사용
        supportActionBar?.setDisplayShowCustomEnabled(true)

        //기존 액션바 기능 숨김
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)

        var actionView = layoutInflater.inflate(R.layout.custom_acitonbar, null)
        supportActionBar?.customView = actionView

        var actionText = actionView.findViewById<TextView>(R.id.textView)
        actionText.text = "커스텀 액션바"
        actionText.setTextColor(Color.WHITE)

        var actionBtn = actionView.findViewById<Button>(R.id.button)
        actionBtn.setOnClickListener { view->
            Toast.makeText(this, "버튼을 눌렀습니다.", Toast.LENGTH_LONG).show()
        }
        return true
    }
}
