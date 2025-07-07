package com.example.testtaskcard.data.dataBase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_info")
data class CardInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "bin")
    val bin: String,

    @ColumnInfo(name = "scheme")
    val scheme: String?,

    @ColumnInfo(name = "type")
    val type: String?,

    @ColumnInfo(name = "brand")
    val brand: String?,

    @ColumnInfo(name = "prepaid")
    val prepaid: Boolean?,

    @ColumnInfo(name = "length")
    val length: Int?,

    @ColumnInfo(name = "luhn")
    val luhn: Boolean?,

    @ColumnInfo(name = "latitude")
    val latitude: Double?,

    @ColumnInfo(name = "longitude")
    val longitude: Double?,

    @ColumnInfo(name = "country_name")
    val countryName: String?,

    @ColumnInfo(name = "country_emoji")
    val countryEmoji: String?,
) {
    companion object {
        val EMPTY = CardInfoEntity(
            bin = "",
            scheme = null,
            type = null,
            brand = null,
            prepaid = null,
            length = null,
            luhn = null,
            latitude = null,
            longitude = null,
            countryName = null,
            countryEmoji = null
        )
    }
}