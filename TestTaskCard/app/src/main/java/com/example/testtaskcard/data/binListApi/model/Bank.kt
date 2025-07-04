package com.example.testtaskcard.data.binListApi.model

import com.google.gson.annotations.SerializedName

data class Bank(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val website: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("city") val city: String?
) {
    companion object {
        val EMPTY = Bank(
            name = null,
            website = null,
            phone = null,
            city = null
        )
        val TEST = Bank(
            name = "Tinkoff Bank",
            website = "https://www.tbank.ru/",
            phone = "+78003333333",
            city = "Moscow"
        )
    }
}