package com.example.testtaskcard.ui.theme.screen.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel = hiltViewModel(),
    paddingValues: PaddingValues? = null,
    onBackButtonClick: () -> Unit
) {

    val cardInfoList by viewModel.cardInfoFlow.collectAsState()

    LazyColumn (
        modifier = Modifier.fillMaxSize().padding(paddingValues ?: PaddingValues()).padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { onBackButtonClick() }) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back_button"
                    )
                }
                Text("History", fontSize = 30.sp)
            }
        }
        items(cardInfoList) { card ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                SelectionContainer {
                    Text(
                        text = "BIN: ${card.bin}",
                        fontSize = 20.sp
                    )
                }
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text(
                            text = card.scheme ?: "-",
                            fontSize = 28.sp
                        )
                        Text(text = "Type: ${card.type ?: "-"}")
                        Text(text = "Brand: ${card.brand ?: "-"}")
                        Text(text = "Prepaid: ${card.prepaid ?: "-"}")
                        Text(text = "Length: ${card.length ?: "-"}")
                        Text(text = "Luhn: ${card.luhn ?: "-"}")
                        Text(text = "${card.countryEmoji ?: "-"} ${card.countryName ?: "-"}")
                        Text(text = "Latitude: ${card.latitude ?: "-"}")
                        Text(text = "Longitude: ${card.longitude ?: "-"}")
                    }
                }
            }
        }
    }
}