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

    var cardInfo by mutableStateOf<CardInfoResponse>(CardInfoResponse.TEST)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var textFieldValue by mutableStateOf("")
        private set
    fun onTextFieldChanged(value: String) {
        textFieldValue = value
    }

    fun validateField() {

    }

    fun fetchCardInfoBin() {
        isLoading = true
        viewModelScope.launch {
            val cardInfoResult = binListRepository.getCardInfoByBin(textFieldValue)
            cardInfoResult.onSuccess { card ->
                cardInfo = card
            }.onFailure {
                cardInfo = CardInfoResponse.EMPTY
            }
            isLoading = false
        }
    }

}