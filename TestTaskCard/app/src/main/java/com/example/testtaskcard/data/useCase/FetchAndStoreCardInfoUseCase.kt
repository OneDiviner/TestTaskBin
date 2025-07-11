package com.example.testtaskcard.data.useCase

import android.util.Log
import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse

import javax.inject.Inject

class FetchAndStoreCardInfoUseCase @Inject constructor(
    private val fetchCardInfoUseCase: FetchCardInfoUseCase,
    private val insertCardInfoIntoHistoryUseCase: InsertCardInfoInTableUseCase
) {
    suspend operator fun invoke(bin: String) : CardInfoResponse {
        val fetchResult = fetchCardInfoUseCase(bin)
        fetchResult.onSuccess { cardInfo ->
            if (cardInfo != CardInfoResponse.EMPTY) {
                insertCardInfoIntoHistoryUseCase(cardInfo, bin)
                return cardInfo
            }
        }
        return CardInfoResponse.EMPTY
    }
}