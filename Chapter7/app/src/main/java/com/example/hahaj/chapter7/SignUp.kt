package com.example.hahaj.chapter7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_signup.setOnClickListener {
            var userID: String = input_id.text.toString()
            var userPW: String = input_pw.text.toString()
            var userPWCK: String = input_pwck.text.toString()

            //성공 시 로그인으로 돌아감
            if(userID == "" || userPW == "" || userPWCK == ""){
                Toast.makeText(this, "빠짐없이 입력해주세요", Toast.LENGTH_LONG).show()
            }else {
                val signupTosignin = Intent(this, SignIn::class.java)
                startActivity(signupTosignin)
                finish()
            }
        }
    }
}
