package com.example.testtaskcard.ui.theme.screen.cardInfo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse
import com.example.testtaskcard.data.binListApi.repository.BinListRepository
import com.example.testtaskcard.data.dataBase.entity.CardInfoEntity
import com.example.testtaskcard.data.dataBase.repository.CardInfoRepository
import com.example.testtaskcard.data.useCase.FetchAndStoreCardInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardInfoViewModel @Inject constructor(
    private val fetchAndStoreCardInfoUseCase: FetchAndStoreCardInfoUseCase
) : ViewModel() {

    var cardInfo by mutableStateOf<CardInfoResponse>(CardInfoResponse.TEST)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var isError by mutableStateOf(false)
        private set

    var textFieldValue by mutableStateOf("")
        private set
    fun onTextFieldChanged(value: String) {
        textFieldValue = value
    }

    fun validateField(bin: String) : Boolean {
        return bin.length == 6 || bin.length == 8
    }

    fun fetchCardInfoBin() {
        isLoading = true
        if (validateField(textFieldValue)) {
            isError = false
            viewModelScope.launch {
                cardInfo = fetchAndStoreCardInfoUseCase(textFieldValue)
                isLoading = false
            }
        } else {
            isError = true
            isLoading = false
        }

    }

}