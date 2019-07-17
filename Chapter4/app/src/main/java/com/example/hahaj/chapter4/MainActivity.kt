package com.example.hahaj.chapter4

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.*
import com.example.hahaj.chapter4.R.layout.student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentAdapter = StudentAdapter(applicationContext, ArrayList<Student>())
        listView.adapter = studentAdapter
        listView.layoutManager = LinearLayoutManager(applicationContext)
        listView.setHasFixedSize(true)

        btnPlus.setOnClickListener { v: View? ->
            var alertBuilder = AlertDialog.Builder(this)
            alertBuilder.setTitle("학생 정보 입력")
            alertBuilder.setIcon(R.mipmap.ic_launcher)

            var alert1 = layoutInflater.inflate(R.layout.input_student, null)
            alertBuilder.setView(alert1)

            var diaListener = object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {

                    var alert = p0 as AlertDialog
                    var studentName:String? = alert.findViewById<EditText>(R.id.inputName)?.text.toString()
                    var studentAge:Int? = alert.findViewById<EditText>(R.id.inputAge)?.text.toString().toInt()
                    var studentMajor:String? = alert.findViewById<EditText>(R.id.inputMajor)?.text.toString()

                    Log.d("입력받은 객체 이름 확인", ""+studentName)
                    Log.d("입력받은 객체 나이 확인", ""+studentAge)
                    Log.d("입력받은 객체 전공 확인", ""+studentMajor)

                    studentAdapter.add(Student(studentName, studentAge, studentMajor))
                    studentAdapter.notifyDataSetChanged()

                }
            }
            alertBuilder.setPositiveButton("추가", diaListener)
            alertBuilder.setNegativeButton("취소", diaListener)
            alertBuilder.show()
        }
    }
}
