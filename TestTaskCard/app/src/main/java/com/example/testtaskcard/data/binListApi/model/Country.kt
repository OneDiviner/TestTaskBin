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
    }
}