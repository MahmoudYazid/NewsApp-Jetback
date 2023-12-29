package com.example.news.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "articles")
data class articlesDatabaseEntity(
    @PrimaryKey(autoGenerate = true) var id :Int?,
    val img: String,
    val title: String,
    val link: String
)