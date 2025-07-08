package com.example.testtaskcard.data.useCase

import com.example.testtaskcard.data.dataBase.entity.CardInfoEntity
import com.example.testtaskcard.data.dataBase.repository.ICardInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCardInfoFlowListFromTableUseCase @Inject constructor(
    private val cardInfoRepository: ICardInfoRepository
) {
    operator fun invoke(): Flow<List<CardInfoEntity>> {
        return cardInfoRepository.getAllCardInfo()
    }
}