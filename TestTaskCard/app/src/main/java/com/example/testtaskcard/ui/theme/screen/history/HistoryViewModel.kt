package com.example.testtaskcard.ui.theme.screen.history

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskcard.data.binListApi.model.response.CardInfoResponse
import com.example.testtaskcard.data.dataBase.entity.CardInfoEntity
import com.example.testtaskcard.data.dataBase.repository.CardInfoRepository
import com.example.testtaskcard.data.useCase.GetCardInfoFlowListFromTableUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getCardInfoFlowListFromTableUseCase: GetCardInfoFlowListFromTableUseCase
) : ViewModel() {
    private val _cardInfoFlow = MutableStateFlow<List<CardInfoEntity>>(emptyList())
    val cardInfoFlow: StateFlow<List<CardInfoEntity>> = _cardInfoFlow.asStateFlow()

    init {
        collectInfoCard()
    }

    fun collectInfoCard() {
        viewModelScope.launch {
            getCardInfoFlowListFromTableUseCase().collect {
                _cardInfoFlow.value = it
            }
        }
    }
}