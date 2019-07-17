package com.example.hahaj.chapter7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boardAdapter = BoardAdapter(applicationContext, ArrayList<Board>())
        listView.adapter = boardAdapter
        listView.layoutManager = LinearLayoutManager(applicationContext)
        listView.setHasFixedSize(true)

        var intent = getIntent()
        //res.text = intent.getStringExtra("title")+"\n"
        //var boardTitles: String
        //var boardContents: String
        //var boardAuthors: String

        if(intent.hasExtra("title")) {
            var boardTitles= intent.getStringExtra("title")
            var boardContents= intent.getStringExtra("content")
            var boardAuthors= intent.getStringExtra("author")

            boardAdapter.add(Board(boardTitles, boardContents, boardAuthors))
            boardAdapter.notifyDataSetChanged()
        }
    }
    //옵션 메뉴 활성화
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    //옵션메뉴에서 항목 선택
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.opt_write -> {
                val mainToBoardRgst = Intent(this, BoardRgst::class.java)
                startActivity(mainToBoardRgst)
            }
            R.id.opt_signout -> {
                //로그아웃
                Toast.makeText(applicationContext, "로그아웃", Toast.LENGTH_LONG).show()
            }
        }
        return true
    }
}
