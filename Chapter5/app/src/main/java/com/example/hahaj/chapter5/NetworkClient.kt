package com.example.hahaj.chapter5

import android.util.JsonReader
import android.util.Log
import android.widget.Toast
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class NetworkClient{
    var client = OkHttpClient()

    fun requestPost(url: String, id:String, password:String){
        var requestBody = FormBody.Builder()
            .add("userId", id)
            .add("userPW", password)
            .build()

        var request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("error", "Connect Server Error : "+e.toString())
                //Toast.makeText(this, "로그인이 실패하였습니다.", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call, response: Response)  {
                Log.d("aaa", "Response Body : "+response.body().toString())
                Log.d("로그인 성공ㅠ", "Response : "+response.body())
                Log.d("response : ", ""+response)
                var strJson = response.body()?.string()
                Log.d("확인2", ""+strJson)


            }
        })
    }
}
   /* fun get(url: String) : InputStream{
        val request = Request.Builder().url(url).build()
        val response = OkHttpClient().newCall(request).execute()
        val body = response.body()
        return body!!.byteStream()
    }*/
