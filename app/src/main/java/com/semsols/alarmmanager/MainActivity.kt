package com.semsols.alarmmanager

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.semsols.alarmmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        NotificationChannel()


    }

    private fun NotificationChannel() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val name : CharSequence = "androidReminderChannel"
            val description = "Alarm Manager Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = android.app.NotificationChannel("android",name, importance)
            channel.description = description
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )

            notificationManager.createNotificationChannel(channel)

        }


    }
}