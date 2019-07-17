package com.example.hahaj.studydialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.min

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view->
            var builder = AlertDialog.Builder(this)
            builder.setTitle("다이얼로그")
            builder.setMessage("다이올로그 본문")
            builder.setIcon(R.mipmap.ic_launcher)

            var listener = object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    when(which){
                        DialogInterface.BUTTON_POSITIVE ->
                            textView.text ="positive"
                        DialogInterface.BUTTON_NEUTRAL ->
                            textView.text ="Neutral"
                        DialogInterface.BUTTON_NEGATIVE ->
                            textView.text ="Negative"
                    }
                }
            }
            builder.setPositiveButton("Positivie", listener)
            builder.setNeutralButton("Neutral", listener)
            builder.setNegativeButton("Negative", listener)
            //var alert = builder.create()
            //alert.show()
            builder.show()
        }

        button2.setOnClickListener { view->
            var builder2 = AlertDialog.Builder(this)
            builder2.setTitle("커스텀 다이얼로그")
            builder2.setIcon(R.mipmap.ic_launcher)

            var v1 = layoutInflater.inflate(R.layout.dialog2, null)
            builder2.setView(v1)

            var listener2 = object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    var alert = dialog as AlertDialog
                    var edit1:EditText? = alert.findViewById<EditText>(R.id.editText)
                    var edit2:EditText? = alert.findViewById<EditText>(R.id.editText2)

                    textView.text = "edit1: ${edit1?.text}\n"
                    textView.append("edit2: ${edit2?.text}")
                }
            }
            builder2.setPositiveButton("확인",listener2)
            builder2.setNegativeButton("취소", null)
            builder2.show()

        }
        button3.setOnClickListener { view->
            var builder3 = Calendar.getInstance()
            var year = builder3.get(Calendar.YEAR)
            var month = builder3.get(Calendar.MONTH)
            var day = builder3.get(Calendar.DAY_OF_MONTH)

            var listener3 = object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    textView.text = "${year}년 ${month+1}월 ${dayOfMonth}일\n"
                }
            }
            var picker = DatePickerDialog(this, listener3, year, month, day)
            picker.show()
        }

        button4.setOnClickListener { view->
            var calendar = Calendar.getInstance()
            var hour = calendar.get(Calendar.HOUR)
            var minute = calendar.get(Calendar.MINUTE)

            var listener4 = object :TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    textView.text="${hourOfDay}시 ${minute}분\n"
                }
            }
            var time_picker = TimePickerDialog(this, listener4, hour, minute, true)
            time_picker.show()
        }
    }
}
