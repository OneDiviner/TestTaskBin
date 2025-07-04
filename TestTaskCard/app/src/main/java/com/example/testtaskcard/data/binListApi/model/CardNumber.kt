package com.example.testtaskcard.data.binListApi.model

import com.google.gson.annotations.SerializedName

data class CardNumber(
    @SerializedName("length") val length: Int?,
    @SerializedName("luhn") val isLuhnValid: Boolean?
) {
    companion object {
        val EMPTY = CardNumber(
            length = null,
            isLuhnValid = null
        )
        val TEST = CardNumber(
            length = 16,
            isLuhnValid = true
        )
    }
}