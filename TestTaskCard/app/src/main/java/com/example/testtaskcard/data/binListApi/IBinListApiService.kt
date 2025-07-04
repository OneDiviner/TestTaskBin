package com.example.testtaskcard.data.binListApi

import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IBinListApiService {
    @GET("/{bin}")
    suspend fun getCardInfoByBin(@Path("bin") bin: String) : Response<CardInfoResponse>
}