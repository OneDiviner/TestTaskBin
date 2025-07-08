package com.example.testtaskcard.data.useCase

import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse
import com.example.testtaskcard.data.binListApi.repository.IBinListRepository
import javax.inject.Inject

class FetchCardInfoUseCase @Inject constructor(
    private val binListRepository: IBinListRepository
) {
    suspend operator fun invoke(bin: String) : Result<CardInfoResponse> {
        return binListRepository.getCardInfoByBin(bin)
    }
}