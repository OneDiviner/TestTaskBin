package com.example.testtaskcard.data.binListApi.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("numeric") val numericCode: String?,
    @SerializedName("alpha2") val alpha2Code: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("emoji") val emoji: String?,
    @SerializedName("currency") val currency: String?,
    @SerializedName("latitude") val latitude: Double?,
    @SerializedName("longitude") val longitude: Double?
) {
    companion object {
        val EMPTY = Country(
            numericCode = null,
            alpha2Code = null,
            name = null,
            emoji = null,
            currency = null,
            latitude = null,
            longitude = null
        )
        val TEST = Country(
            numericCode = "643",
            alpha2Code = "RU",
            name = "Russian Federation",
            emoji = "\uD83C\uDDF7\uD83C\uDDFA",
            currency = "RUB",
            latitude = 60.0,
            longitude = 100.0
        )
    }
}