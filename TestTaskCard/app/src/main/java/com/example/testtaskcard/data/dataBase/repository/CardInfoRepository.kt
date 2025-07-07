package com.example.testtaskcard.data.dataBase.repository

import com.example.testtaskcard.data.dataBase.dao.CardInfoDao
import com.example.testtaskcard.data.dataBase.entity.CardInfoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CardInfoRepository @Inject constructor(
    private val cardInfoDao: CardInfoDao
) : ICardInfoRepository {
    override suspend fun insertCardInfo(cardInfoEntity: CardInfoEntity) {
        cardInfoDao.insertCardInfo(cardInfoEntity)
    }

    override fun getAllCardInfo(): Flow<List<CardInfoEntity>> {
        return cardInfoDao.getAllCardInfo()
    }
}