package com.example.testtaskcard.ui.theme.screen.cardInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RowItem(
    modifier: Modifier = Modifier,
    title: String,
    text: String
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground.copy(0.8f)
        )
        Text(
            text = text,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun CardInfoScreen(
    viewModel: CardInfoViewModel = hiltViewModel(),
    paddingValues: PaddingValues? = null
) {
    LazyColumn (
        modifier = Modifier.fillMaxSize().padding(paddingValues ?: PaddingValues()).padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        item {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.textFieldValue,
                onValueChange = { viewModel.onTextFieldChanged(it) },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                label = {
                    Text("BIN")
                },
                shape = RoundedCornerShape(18.dp)
            )
        }
        item {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    RowItem(
                        title = "SCHEME",
                        text = viewModel.testData.scheme ?: "-"
                    )
                    RowItem(
                        title = "BRAND",
                        text = viewModel.testData.brand ?: "-"
                    )
                    Column {
                        Text("CARD NUMBER", fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground.copy(0.5f))
                        Row(
                            modifier = Modifier,
                        ) {
                            RowItem(
                                title = "LENGTH",
                                text = viewModel.testData.number?.length?.toString() ?: "-"
                            )
                            RowItem(
                                title = "LUNH",
                                text = viewModel.testData.number?.isLuhnValid?.toString() ?: "-"
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    RowItem(
                        title = "TYPE",
                        text = viewModel.testData.type ?: "-"
                    )
                    RowItem(
                        title = "PREPAID",
                        text = viewModel.testData.isPrepaid?.toString() ?: "-"
                    )
                    Column {
                        Text("COUNTRY", fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground.copy(0.5f))
                        Row {
                            Text(
                                text = viewModel.testData.country?.emoji ?: "-",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = viewModel.testData.country?.name ?: "-",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Text(
                            text = "latitude: ${viewModel.testData.country?.latitude ?: "-"},",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onBackground.copy(0.8f)
                        )
                        Text(
                            text = "longitude: ${viewModel.testData.country?.longitude ?: "-"}",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onBackground.copy(0.8f)
                        )
                    }
                }
            }
        }
        item {
            Text(
                text = "BANK",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground.copy(0.5f)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "${viewModel.testData.bank?.name ?: "-"}, ${viewModel.testData.bank?.city ?: "-"}",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = viewModel.testData.bank?.website ?: "-",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(0.8f)
                )
                Text(
                    text = viewModel.testData.bank?.phone ?: "-",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(0.8f)
                )
            }
        }
    }
}