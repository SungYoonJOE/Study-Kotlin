package com.example.hahaj.studyokhttp3

import android.content.DialogInterface
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import org.json.JSONObject
import java.io.IOException
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.login->{
                var builder : AlertDialog.Builder = AlertDialog.Builder(this)
                builder.setTitle("로그인")
                    .setView(layoutInflater.inflate(R.layout.dialog_login, null))

                var loginListener = object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        var alert:AlertDialog = dialog as AlertDialog
                        var id:String = alert.findViewById<EditText>(R.id.inputID)?.text.toString()
                        var password:String = alert.findViewById<EditText>(R.id.inputPW)?.text.toString()

                        Asynctask().execute(getString(R.string.server_url), id, password)

                    }
                }
                builder.setPositiveButton("로그인", loginListener)
                builder.setNegativeButton("취소", null)

                builder.show()
            }
        }
        return true
    }
    //백그라운드에서 통신 https://hangouts.google.com/call/4C-WFfsiUJlZB7OzI69MAEEM
    inner class Asynctask: AsyncTask<String?, Void, String?>(){
        var id:String? = null

        override fun onPreExecute() {
            super.onPreExecute()
        }
        override fun doInBackground(vararg params: String?): String? {
            var client = OkHttpClient()
            //0번째는 url, 1번째는 id, 2번째는 pw
            id = params[1]
            var pw:String? = params[2]
            var url:String? = params[0]

            var response : String? = null

            try{
                var okHttpApi = OkHttpApi()
                response = okHttpApi.POST(client, url, okHttpApi.jsonbody(id, pw))
                return response
            }catch (e : IOException){
                e.toString()
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if(result?.get(0) != '{') {
                Toast.makeText(applicationContext, "통신 결과가 json이 아닙니다.", Toast.LENGTH_LONG).show()
            }
            else{
                var jsonObject = JSONObject(result)
                if(jsonObject.getInt("result")!= 0){
                    textView.text="${id}님 환영합니다."
                }
                else{
                    Toast.makeText(applicationContext, "로그인이 실패하였습니다.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
