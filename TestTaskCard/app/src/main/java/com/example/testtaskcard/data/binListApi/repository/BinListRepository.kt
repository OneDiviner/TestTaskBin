package com.example.testtaskcard.data.binListApi.repository

import android.util.Log
import com.example.testtaskcard.data.binListApi.IBinListApiService
import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse
import javax.inject.Inject

class BinListRepository @Inject constructor(
    private val binListApiService: IBinListApiService
) : IBinListRepository {
    override suspend fun getCardInfoByBin(bin: String): Result<CardInfoResponse> {
        return try {
            val cardInfoResponse = binListApiService.getCardInfoByBin(bin = bin)
            Log.d("BinListRepository", "getCardInfoByBin: ${cardInfoResponse.body()}")
            Result.success(cardInfoResponse.body() ?: CardInfoResponse.EMPTY)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}