package com.example.hahaj.studynotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view->
            //notification builder를 먼저 만들어줘야함
            //var builder = NotificationCompat.Builder(this) // ~Compat : 하위버전에서도 지원하기 위해 만들어짐
            var builder = getNotificationBuilder("channel1", "첫번째 채널")
            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher) //이미지를 객체로 만든 것 = bitmap
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title")
            builder.setContentText("Content")

            var notification = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(10, notification) //각 알람메시지를 구분하기 위한 아이디
        }

        button2.setOnClickListener { view ->
            var builder = getNotificationBuilder("channel1", "첫번째 채널")
            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher) //이미지를 객체로 만든 것 = bitmap
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title2")
            builder.setContentText("Content2")

            var notification = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(20, notification) //각 알람메시지를 구분하기 위한 아이디
        }

        button3.setOnClickListener { view ->
            var builder = getNotificationBuilder("channel2", "두 번째 채널")
            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher) //이미지를 객체로 만든 것 = bitmap
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title3")
            builder.setContentText("Content3")

            var notification = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(30, notification) //각 알람메시지를 구분하기 위한 아이디
        }
    }

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder{
        var builder:NotificationCompat.Builder? = null
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ //오레오 이상
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH) //중요도에 따라 순서가 달라짐
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, id)
        }else{
            builder = NotificationCompat.Builder(this)
        }
        return builder
    }

}
