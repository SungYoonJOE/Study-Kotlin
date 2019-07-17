package com.example.hahaj.chapter7

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BoardAdapter(val context: Context, val boardList: ArrayList<Board>): RecyclerView.Adapter<BoardAdapter.Holder>(){
    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.bind(boardList[p1], context)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.board, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return boardList.size
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        val boardTitle = itemView.findViewById<TextView>(R.id.boardTitle)
        val boardContent = itemView.findViewById<TextView>(R.id.boardContent)
        val boardAuthor = itemView.findViewById<TextView>(R.id.boardAuthor)

        fun bind(board: Board, context: Context){
            boardTitle.text = board.title
            boardContent.text = board.content
            boardAuthor.text = board.author
        }
    }

    fun add(board: Board?){
        if(board == null) return
        boardList.add(0, board)
    }
}