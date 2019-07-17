package com.example.hahaj.studyactionbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //옵션메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    //메뉴 클릭하면 호출
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?. itemId){
            R.id.item1 -> {
                textView.text = "1번 메뉴"
            }
            R.id.item2 -> {
                textView.text = "2번 메뉴"
            }
            R.id.item3 -> {
                textView.text= "3번 메뉴"
            }
            R.id.item4 -> {
                textView.text= "4번 메뉴"
            }
        }
        return true
    }

}

/*
showAsAction
- None : 기본 ActionBar에 표시하지 않음
- Always : 무조건 ActionBar에 표시함
- ifRoom : ActionBar에 공간이 허락할 경우 표시
- Icon : ActionBar에 표시될 때 사용할 아이콘을 지정함
- withText : 공간이 허락할 경우 아이콘과 함께 문자열을 표시
*/