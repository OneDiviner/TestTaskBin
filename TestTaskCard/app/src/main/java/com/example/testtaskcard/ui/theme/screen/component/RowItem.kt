package com.example.testtaskcard.ui.theme.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

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