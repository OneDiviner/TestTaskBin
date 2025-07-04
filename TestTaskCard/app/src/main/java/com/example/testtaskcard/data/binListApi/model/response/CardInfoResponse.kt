package com.example.testtaskcard.data.binListApi.model.response

import com.example.testtaskcard.data.binListApi.model.Bank
import com.example.testtaskcard.data.binListApi.model.CardNumber
import com.example.testtaskcard.data.binListApi.model.Country
import com.google.gson.annotations.SerializedName

data class CardInfoResponse(
    @SerializedName("number") val number: CardNumber?,
    @SerializedName("scheme") val scheme: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("brand") val brand: String?,
    @SerializedName("prepaid") val isPrepaid: Boolean?,
    @SerializedName("country") val country: Country?,
    @SerializedName("bank") val bank: Bank?
) {
    companion object {
        val EMPTY = CardInfoResponse(
            number = CardNumber.EMPTY,
            scheme = null,
            type = null,
            brand = null,
            isPrepaid = null,
            country = Country.EMPTY,
            bank = Bank.EMPTY
        )
        val TEST = CardInfoResponse(
            number = CardNumber.TEST,
            scheme = "mir",
            type = "credit",
            brand = "Premium",
            isPrepaid = false,
            country = Country.TEST,
            bank = Bank.TEST
        )
    }
}