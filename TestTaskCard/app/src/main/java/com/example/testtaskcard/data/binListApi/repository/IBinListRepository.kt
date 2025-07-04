package com.example.testtaskcard.data.binListApi.repository

import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse

interface IBinListRepository {
    suspend fun getCardInfoByBin(bin: String) : Result<CardInfoResponse>
}