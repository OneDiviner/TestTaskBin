package com.example.testtaskcard.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtaskcard.data.dataBase.dao.CardInfoDao
import com.example.testtaskcard.data.dataBase.entity.CardInfoEntity

@Database(entities = [CardInfoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cardInfoDao(): CardInfoDao
}