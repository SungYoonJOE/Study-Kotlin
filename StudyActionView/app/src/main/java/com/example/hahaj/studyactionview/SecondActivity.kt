package com.example.hahaj.studyactionview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//Study ActionBarNavigation
        var action2 = supportActionBar
        action2?.setHomeButtonEnabled(true)
        action2?.setDisplayHomeAsUpEnabled(true)
        //action2?.setHomeAsUpIndicator(android.R.drawable.ic_menu_directions) //<- 아이콘 이미지 변경
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> {
                finish() //현재 activity종료하고 뒤로 가게 됨
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

