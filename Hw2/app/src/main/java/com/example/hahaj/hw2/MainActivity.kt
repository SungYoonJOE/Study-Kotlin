package com.example.hahaj.hw2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            if (checkbox.isChecked == true) {
                textView.setText("체크박스 선택")
            } else {
                textView.setText("체크박스 선택 안 함")
            }
        }
        
        var listener = RadioListener()
        radioGroup.setOnCheckedChangeListener(listener)
    }

   inner class RadioListener:RadioGroup.OnCheckedChangeListener{
       override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
           when(group?.id){
               R.id.radioGroup ->
                   when(checkedId){
                       R.id.radioBtn1 -> checkbox.isEnabled = true
                       R.id.radioBtn2 -> checkbox.isEnabled = false
               }
           }
       }
   }
}

