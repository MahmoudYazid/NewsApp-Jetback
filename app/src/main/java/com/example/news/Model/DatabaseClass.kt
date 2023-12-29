package com.example.news.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [articlesDatabaseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ArticleDaoFunction(): articlesDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "articlesDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}