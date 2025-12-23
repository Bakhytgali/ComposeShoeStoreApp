package com.example.shoe_store.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ShopItemPageSectionHeader(
    header: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = header,
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.fillMaxWidth(0.95f),
        textAlign = TextAlign.Start
    )
}