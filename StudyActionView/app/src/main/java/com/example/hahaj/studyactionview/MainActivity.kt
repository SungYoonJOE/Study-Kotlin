package com.example.hahaj.studyactionview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var searchView:SearchView? = null

    var dataList = arrayOf("aa", "bbbb", "cccac", "ddddcd", "ddddccd", "eebbee")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Study ActionBarNavigation
        btn_second.setOnClickListener { view->
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList)
        list1.adapter = adapter
        //listview 검색기능
        list1.isTextFilterEnabled = true //listview 검색기능 활성화
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        var item = menu?.findItem(R.id.item1) //searchView가 R.id.item1에 있기 때문
        var listener = ActionListener()
        item?.setOnActionExpandListener(listener)

        searchView = item?.actionView as SearchView
        searchView?.queryHint="입력해주세요"//안내문구
        var listener2 = ActionListener2()
        searchView?.setOnQueryTextListener(listener2)
        return true
    }
    //ActionBar가 접혔을 때, 펴졌을 때 이벤트처리를 할 수 있음
    inner class ActionListener : MenuItem.OnActionExpandListener{
        //접혔을 때 호출
        override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
            textView.text="접힘"
            return true
        }
        //펼쳐졌을 때 호출
        override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
            textView.text="펼침"
            return true
        }
    }

    //SearchView에 변화가 있을 때 이벤트 처리
    inner class ActionListener2 : SearchView.OnQueryTextListener{
        //입력할 때 호출
        override fun onQueryTextChange(p0: String?): Boolean {
            textView2.text=p0
            list1.setFilterText(p0)//검색한 값만 남아있게 됨

            if(p0?.length == 0){ //검색어 지웠을 때 안 남아있게!!
                list1.clearTextFilter()
            }
            return true
        }
        //키보드의 확인 버튼을 눌렀을 때 호출
        override fun onQueryTextSubmit(p0: String?): Boolean {
            textView2.text ="엔터키 : ${p0}"
            searchView?.clearFocus() //Enter key를 누르면 닫을 수 있음
            return true
        }
    }
}
