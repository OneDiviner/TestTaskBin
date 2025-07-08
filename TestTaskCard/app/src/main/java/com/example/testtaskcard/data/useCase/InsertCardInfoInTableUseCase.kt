package com.example.testtaskcard.data.useCase

import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse
import com.example.testtaskcard.data.dataBase.repository.ICardInfoRepository
import com.example.testtaskcard.data.mapper.CardInfoMapper.toEntity
import javax.inject.Inject

class InsertCardInfoInTableUseCase @Inject constructor(
    private val cardInfoRepository: ICardInfoRepository
) {
    suspend operator fun invoke(cardInfo: CardInfoResponse, bin: String) {
        cardInfoRepository.insertCardInfo(cardInfo.toEntity(bin))
    }
}