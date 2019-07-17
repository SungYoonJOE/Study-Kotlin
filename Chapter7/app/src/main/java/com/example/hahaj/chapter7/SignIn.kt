package com.example.hahaj.chapter7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        //로그인
        btn_signin.setOnClickListener {
            var userID: String = input_id.text.toString()
            var userPW: String = input_pw.text.toString()

            //textView.setText("user의 id: ${userID}\n user의 pw: ${userPW}")

            //통신 성공 -> 메인 이동
            if (userID == "" || userPW == ""){
                Toast.makeText(this, "빠짐없이 입력해주세요", Toast.LENGTH_LONG).show()
            }else{
                val signinTomain = Intent(this, MainActivity::class.java)
                startActivity(signinTomain)
            }
            //통신 실패 -> 토스트
        }
        //회원가입
        btn_signup.setOnClickListener {
            val signinTosignup = Intent(this, SignUp::class.java)
            startActivity(signinTosignup)
        }
    }
}
