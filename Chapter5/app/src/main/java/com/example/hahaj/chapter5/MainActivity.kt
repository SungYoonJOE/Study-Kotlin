package com.example.hahaj.chapter5

import android.app.Dialog
import android.content.DialogInterface
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.text.Normalizer

class MainActivity : AppCompatActivity() {

    val url = "https://8731a4ed-d833-4a6e-9c6f-aea06ed7c599.mock.pstmn.io/smulookie_ch6?id=asdf&password=asdf1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //옵션메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    //옵션메뉴에서 항목 선택
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.signin -> {
                //로그인 다이얼로그 띄우기
                var signinBuilder = AlertDialog.Builder(this)
                signinBuilder.setTitle("로그인하기")
                signinBuilder.setIcon(R.mipmap.ic_launcher)

                var alert1 = layoutInflater.inflate(R.layout.dialog_signin, null)
                signinBuilder.setView(alert1)

                var signinListener = object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {

                        var alert = dialog as AlertDialog
                        var userID: String? = alert.findViewById<EditText>(R.id.inputID)?.text.toString()
                        var userPW: String? = alert.findViewById<EditText>(R.id.inputPW)?.text.toString()

                        Log.d("로그인 확인 ID", "" + userID)
                        Log.d("로그인 확인 PW", "" + userPW)

                        var postParams = HashMap<String, String>()
                        postParams.put("userId", userID.toString())
                        postParams.put("userPw", userPW.toString())

                        //로그인 통신
                        var connectServerPost = NetworkClient()
                        connectServerPost.requestPost(url, userID.toString(), userPW.toString())
                        textView.text="${userID}님 환영합니다.\n"
                    }
                }
                signinBuilder.setPositiveButton("확인", signinListener)
                signinBuilder.setNegativeButton("취소", null)
                signinBuilder.show()
            }
            R.id.signout -> {
                //로그아웃 다이얼로그 띄우기
                var signoutBuilder = AlertDialog.Builder(this)
                signoutBuilder.setTitle("로그아웃 알림")
                signoutBuilder.setMessage("로그아웃 하시겠습니까?")

                var signoutListener = object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        when (which) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                //로그아웃
                                textView.text = "로그아웃 통신"
                            }
                        }
                    }
                }
                signoutBuilder.setPositiveButton("확인", signoutListener)
                signoutBuilder.setNegativeButton("취소", null)
                signoutBuilder.show()
            }
        }
        return true
    }

}
