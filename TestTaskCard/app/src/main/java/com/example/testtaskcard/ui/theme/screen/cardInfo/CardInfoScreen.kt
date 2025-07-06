package com.example.testtaskcard.ui.theme.screen.cardInfo

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.core.net.toUri

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
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    LazyColumn (
        modifier = Modifier.fillMaxSize().padding(paddingValues ?: PaddingValues()).padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        item {
            Row {
                TextField(
                    modifier = Modifier.weight(1f),
                    value = viewModel.textFieldValue,
                    onValueChange = { viewModel.onTextFieldChanged(it) },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    label = {
                        Text("BIN")
                    },
                    shape = RoundedCornerShape(18.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                            viewModel.fetchCardInfoBin()
                        }
                    ),
                    trailingIcon = {
                        if (viewModel.isLoading) {CircularProgressIndicator(modifier = Modifier.size(25.dp), strokeWidth = 2.dp)} else {null}
                    },
                    isError = false,
                    supportingText = {
                        Text("Enter the first 6 to 8 digits of a card number (BIN/IIN)")
                    }
                )
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "History"
                    )
                }
            }

            Button(
                modifier = Modifier.fillMaxWidth().height(56.dp).padding(top = 10.dp),
                onClick = {

                },
                enabled = !viewModel.isLoading && !viewModel.textFieldValue.isBlank(),
                shape = RoundedCornerShape(18.dp)
            ) {
                Text("Lookup", fontSize = 20.sp)
            }
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
                        text = viewModel.cardInfo.scheme ?: "-"
                    )
                    RowItem(
                        title = "BRAND",
                        text = viewModel.cardInfo.brand ?: "-"
                    )
                    Column {
                        Text("CARD NUMBER", fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground.copy(0.5f))
                        Row(
                            modifier = Modifier,
                        ) {
                            RowItem(
                                title = "LENGTH",
                                text = viewModel.cardInfo.number?.length?.toString() ?: "-"
                            )
                            RowItem(
                                title = "LUNH",
                                text = viewModel.cardInfo.number?.isLuhnValid?.toString() ?: "-"
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
                        text = viewModel.cardInfo.type ?: "-"
                    )
                    RowItem(
                        title = "PREPAID",
                        text = viewModel.cardInfo.isPrepaid?.toString() ?: "-"
                    )
                    Column(
                        modifier = Modifier.clickable {
                            if (viewModel.cardInfo.country?.latitude != null && viewModel.cardInfo.country?.longitude != null) {
                                val mapIntent = Intent(Intent.ACTION_VIEW, ("geo:${viewModel.cardInfo.country?.latitude ?: "-"},${viewModel.cardInfo.country?.longitude ?: "-"}").toUri())
                                context.startActivity(mapIntent)
                            }
                        }
                    ) {
                        Text("COUNTRY", fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground.copy(0.5f))
                        Row() {
                            Text(
                                text = viewModel.cardInfo.country?.emoji ?: "-",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = viewModel.cardInfo.country?.name ?: "-",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Text(
                            text = "latitude: ${viewModel.cardInfo.country?.latitude ?: "-"},",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onBackground.copy(0.8f)
                        )
                        Text(
                            text = "longitude: ${viewModel.cardInfo.country?.longitude ?: "-"}",
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
                    text = "${viewModel.cardInfo.bank?.name ?: "-"}, ${viewModel.cardInfo.bank?.city ?: "-"}",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = viewModel.cardInfo.bank?.website ?: "-",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary.copy(0.8f),
                    modifier = Modifier.clickable {
                        if(viewModel.cardInfo.bank?.website != null) {
                            val urlIntent = Intent(Intent.ACTION_VIEW, (viewModel.cardInfo.bank?.website ?: "").toUri())
                            context.startActivity(urlIntent)
                        }
                    }
                )
                Text(
                    text = viewModel.cardInfo.bank?.phone ?: "-",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(0.8f),
                    modifier = Modifier.clickable {
                        if (viewModel.cardInfo.bank?.phone != null) {
                            val phoneIntent = Intent(Intent.ACTION_DIAL, ("tel:${viewModel.cardInfo.bank?.phone ?: ""}").toUri())
                            context.startActivity(phoneIntent)
                        }
                    }
                )
            }
        }
    }
}