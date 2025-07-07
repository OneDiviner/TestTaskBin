package com.example.testtaskcard.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtaskcard.data.dataBase.entity.CardInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CardInfoDao {
    @Query("SELECT * FROM card_info")
    fun getAllCardInfo(): Flow<List<CardInfoEntity>>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertCardInfo(cardInfoEntity: CardInfoEntity)
}