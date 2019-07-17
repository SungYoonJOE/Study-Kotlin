package com.example.hahaj.chapter7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_board_rgst.*
import kotlinx.android.synthetic.main.activity_main.*

class BoardRgst : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_rgst)
/*
        val bAdapter = BoardAdapter(MainActivity::class.java, ArrayList<Board>())
        listView.adapter = bAdapter
        listView.layoutManager = LinearLayoutManager(applicationContext)
        listView.setHasFixedSize(true)
*/
        btn_rgst.setOnClickListener {
            var bTitle: String = inputTitle.text.toString()
            var bContent: String = inputContent.text.toString()
            var bAuthor = "성윤"
            //var boards = Board(bTitle, bContent, bAuthor)
            if (bTitle == "" || bContent == ""){
                Toast.makeText(this, "제목, 내용 둘 다 입력해주세요", Toast.LENGTH_LONG).show()
            } else{
                //통신 post로 글 정보 저장
                //글 목록에 넣기

                val rgstTomain = Intent(this, MainActivity::class.java)
                //rgstTomain.putExtra("boards", Board(bTitle, bContent, bAuthor))
                rgstTomain.putExtra("title", bTitle)
                rgstTomain.putExtra("content", bContent)
                rgstTomain.putExtra("author", bAuthor)
                startActivity(rgstTomain)
                finish()

                //bAdapter.add(Board(bTitle, bContent, bAuthor))
                //bAdapter.notifyDataSetChanged()
            }
        }

    }
}
