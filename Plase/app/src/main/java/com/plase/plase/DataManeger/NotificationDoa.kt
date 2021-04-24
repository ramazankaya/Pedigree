package com.plase.plase.DataManeger

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.plase.plase.model.Notification

@Dao
public interface NotificationDoa {
    @Query("SELECT * FROM Notification")
    suspend fun getAll(): List<Notification>

    @Query("SELECT * FROM Notification WHERE NotificationId IN (:NotificationIds)")
    suspend fun loadAllByIds(NotificationIds: IntArray): List<Notification>

    @Query(
        "SELECT * FROM Notification WHERE first_name LIKE :first OR " +
                "last_name LIKE :last LIMIT 1"
    )
    suspend fun findByName(first: String, last: String): Notification

//    @Query("SELECT * FROM Notification WHERE NotificationId" + "= notifaictionId LIMIT 1")
//    suspend fun getNotifitaionWithId(notifaictionId: Int): Notification

    @Insert
    suspend fun insertAll(vararg Notifications: Notification)

    @Delete
    suspend fun delete(Notification: Notification)
}