package com.plase.plase.DataManeger.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plase.plase.DataManeger.NotificationDoa
import com.plase.plase.model.Notification

@Database(entities = arrayOf(Notification::class), version = 2)
abstract class  AppDatabase : RoomDatabase() {
    abstract fun notifactionDoa(): NotificationDoa
}