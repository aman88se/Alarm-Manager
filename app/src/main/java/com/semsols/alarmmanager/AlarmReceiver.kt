package com.semsols.alarmmanager

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver: BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {

        val i = Intent(context,DestActivity::class.java )
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val pendingIntent = PendingIntent.getActivity(context,0,i,0)


        val builder = NotificationCompat.Builder(context!!,"android")
            .setSmallIcon(R.drawable.happynewyear)
            .setContentTitle("Android Alarm Manager")
            .setContentText("Subscribe for more")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(123,builder.build())
        
    }


}