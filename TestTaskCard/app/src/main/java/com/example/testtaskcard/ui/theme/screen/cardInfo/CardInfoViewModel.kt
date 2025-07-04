package com.example.testtaskcard.ui.theme.screen.cardInfo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse
import com.example.testtaskcard.data.binListApi.repository.BinListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardInfoViewModel @Inject constructor(
    private val binListRepository: BinListRepository
) : ViewModel() {

    val testData by mutableStateOf<CardInfoResponse>(CardInfoResponse.TEST)

    var cardInfo by mutableStateOf<CardInfoResponse>(CardInfoResponse.EMPTY)

    var textFieldValue by mutableStateOf("")
        private set

    fun onTextFieldChanged(value: String) {
        textFieldValue = value
    }

    fun fetchCardInfoBin(bin: String) {
        viewModelScope.launch {
            val cardInfoResult = binListRepository.getCardInfoByBin(bin)
            cardInfoResult.onSuccess { card ->
                cardInfo = card
            }.onFailure {
                cardInfo = CardInfoResponse.EMPTY
            }
        }
    }

}