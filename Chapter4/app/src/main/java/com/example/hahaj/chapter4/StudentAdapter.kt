package com.example.hahaj.chapter4

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StudentAdapter(val context: Context, val studentList: ArrayList<Student>):RecyclerView.Adapter<StudentAdapter.Holder>(){
    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.bind(studentList[p1], context)
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.student, p0, false)
        return Holder(view)
    }
    override fun getItemCount(): Int {
        return studentList.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val studentName = itemView.findViewById<TextView>(R.id.studentName)
        val studentAge = itemView.findViewById<TextView>(R.id.studentAge)
        val studentMajor = itemView.findViewById<TextView>(R.id.studentMajor)

        fun bind(student: Student, context: Context) {
            studentName.text = student.name
            studentAge.text = student.age.toString()
            studentMajor.text = student.major
        }
    }

    fun add(student: Student?){
        if(student == null) return
        studentList.add(0, student) //새로 추가되는 값들이 0번째에 추가됨
    }

}