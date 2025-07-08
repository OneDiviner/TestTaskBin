package com.example.testtaskcard.data.useCase

import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse
import com.example.testtaskcard.data.dataBase.entity.CardInfoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAndStoreCardInfoUseCase @Inject constructor(
    private val fetchCardInfoUseCase: FetchCardInfoUseCase,
    private val insertCardInfoIntoHistoryUseCase: InsertCardInfoInTableUseCase
) {
    suspend operator fun invoke(bin: String) : CardInfoResponse {
        val fetchResult = fetchCardInfoUseCase(bin)
        fetchResult.onSuccess { cardInfo ->
            insertCardInfoIntoHistoryUseCase(cardInfo, bin)
            return cardInfo
        }
        return CardInfoResponse.EMPTY
    }
}