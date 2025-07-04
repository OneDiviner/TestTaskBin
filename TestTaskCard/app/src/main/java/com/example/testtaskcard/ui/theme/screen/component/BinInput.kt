package com.example.testtaskcard.ui.theme.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BinInput(
    pinLength: Int = 4,
    onPinComplete: (String) -> Unit
) {

    var pin by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        repeat(pinLength) { index ->
            val isFilled = index < pin.length
            val char = if (isFilled) pin[index] else ' '

            BasicTextField(
                value = char.toString(),
                onValueChange = {
                    if (it.length <= 1) {
                        if (it.isNotEmpty() && it[0].isDigit()) {
                            if (pin.length <= index) {
                                pin += it[0]
                            } else {
                                pin = pin.substring(0, index) + it[0] + pin.substring(index + 1)
                            }

                            if (pin.length == pinLength) {
                                focusManager.clearFocus()
                                onPinComplete(pin)
                            } else if (it.isNotEmpty()) {
                                /*focusRequester[index + 1].requestFocus()*/
                            }
                        } else if (it.isEmpty()) {
                            if (pin.isNotEmpty()) {
                                pin = pin.dropLast(1)
                                if (index > 0) {
                                    /*focusRequester[index - 1].requestFocus()*/
                                }
                            }
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = if (index == pinLength - 1) ImeAction.Done else ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { /*focusRequester[index + 1].requestFocus()*/ },
                    onDone = { focusManager.clearFocus() }
                ),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                ),
                modifier = Modifier
                    .size(56.dp)
                    //.focusRequester(/*focusRequester[index]*/)
                    .onFocusChanged { focusState ->
                        if (focusState.isFocused && pin.length > index) {
                            // Пропускаем автоматический переход если поле уже заполнено
                        }
                    }
                    .background(
                        color = if (isFilled) MaterialTheme.colorScheme.primaryContainer
                        else MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    )
                    .clip(CircleShape)
                    .clickable { /*focusRequester[index].requestFocus()*/ },
                decorationBox = { innerTextField ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        if (char != ' ') {
                            Text(
                                text = char.toString(),
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        } else {
                            Text(
                                text = "○",
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                            )
                        }
                        innerTextField() // Скрытый BasicTextField
                    }
                }
            )
        }
    }

    LaunchedEffect(Unit) {
        //focusRequester[0].requestFocus()
    }
}