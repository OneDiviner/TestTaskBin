package com.example.testtaskcard.data.mapper

import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse
import com.example.testtaskcard.data.dataBase.entity.CardInfoEntity

object CardInfoMapper {
    fun  CardInfoResponse.toEntity(bin: String) : CardInfoEntity {
        return CardInfoEntity(
            bin = bin,
            scheme = scheme,
            type = type,
            brand = brand,
            prepaid = isPrepaid,
            countryName = country?.name,
            countryEmoji = country?.emoji,
            latitude = country?.latitude,
            longitude = country?.longitude,
            length = number?.length,
            luhn = number?.isLuhnValid
        )
    }
}