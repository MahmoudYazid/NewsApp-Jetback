package com.example.news.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface articlesDao {
    @Query("SELECT * FROM articles")
    suspend fun getAll(): List<articlesDatabaseEntity>



    @Insert
    suspend fun insertAll(articles: articlesDatabaseEntity)
    @Query("DELETE FROM articles")
    suspend fun deleteAll()
    @Delete
    suspend fun delete(articles: articlesDatabaseEntity)
}