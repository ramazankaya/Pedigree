package com.plase.plase.dg.Module

import android.content.Context
import androidx.room.Room
import com.plase.plase.DataManeger.Room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun getRoomDataBase(
        @ApplicationContext context: Context): AppDatabase {
        return  Room.databaseBuilder(
            context,
            AppDatabase::class.java, "PlaseLocal"
        ).build()
    }
}