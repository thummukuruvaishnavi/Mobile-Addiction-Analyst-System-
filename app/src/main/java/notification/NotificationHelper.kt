package com.example.mobileaddictionanalystsystem.notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.mobileaddictionanalystsystem.R

object NotificationHelper {

    private const val CHANNEL_ID = "mobile_addiction_channel"

    fun createNotificationChannel(context: Context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                CHANNEL_ID,
                "Mobile Addiction Alerts",
                NotificationManager.IMPORTANCE_HIGH
            )

            channel.description = "Screen time notifications"

            val manager = context.getSystemService(
                NotificationManager::class.java
            )

            manager.createNotificationChannel(channel)
        }
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    fun showNotification(
        context: Context,
        title: String,
        message: String
    ) {

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        NotificationManagerCompat
            .from(context)
            .notify(1, builder.build())
    }
}