package com.example.testtaskcard.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testtaskcard.ui.theme.screen.component.BinInput

@Composable
fun AppScreen(
    viewModel: AppViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it)
        ) {
            Column(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                var textFiledValue by remember { mutableStateOf("") }
                TextField(
                    value = textFiledValue,
                    onValueChange = { value ->
                        textFiledValue = value
                    },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { viewModel.fetchCardInfoBin(textFiledValue) }
                    ),
                )
                Card(
                    modifier = Modifier.fillMaxWidth().aspectRatio(1.55f)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(10.dp)
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.TopStart),
                            text = viewModel.cardInfo.brand ?: "Brand",
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            modifier = Modifier.align(Alignment.TopEnd),
                            text = viewModel.cardInfo.country?.emoji ?: "\uD83C\uDDE9\uD83C\uDDF0",
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            modifier = Modifier.align(Alignment.BottomEnd),
                            text = viewModel.cardInfo.scheme ?: "Scheme",
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = viewModel.cardInfo.number?.length?.toString() ?: "Number",
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
                Text(
                    modifier = Modifier,
                    text = viewModel.cardInfo.bank?.name ?: "Name",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    modifier = Modifier,
                    text = viewModel.cardInfo.bank?.city ?: "City",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    modifier = Modifier,
                    text = viewModel.cardInfo.bank?.phone ?: "Phone",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    modifier = Modifier,
                    text = viewModel.cardInfo.bank?.website ?: "Website",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    modifier = Modifier,
                    text = viewModel.cardInfo.bank?.website ?: "Website",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}