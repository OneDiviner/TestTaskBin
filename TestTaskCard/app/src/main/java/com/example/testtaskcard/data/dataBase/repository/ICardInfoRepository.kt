package com.example.testtaskcard.data.dataBase.repository

import com.example.testtaskcard.data.dataBase.entity.CardInfoEntity
import kotlinx.coroutines.flow.Flow

interface ICardInfoRepository {

    suspend fun insertCardInfo(cardInfoEntity: CardInfoEntity)

    fun getAllCardInfo(): Flow<List<CardInfoEntity>>

}