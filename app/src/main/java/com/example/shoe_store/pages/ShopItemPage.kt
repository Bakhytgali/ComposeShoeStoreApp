package com.example.shoe_store.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.shoe_store.data.ShoeModel
import com.example.shoe_store.data.ShoeStore

@Composable
fun ShopItemPage(
    itemId: String,
    modifier: Modifier = Modifier
) {
    var shoe: ShoeModel? by remember {
        mutableStateOf(null)
    }
    LaunchedEffect(Unit) {
        shoe = ShoeStore.getShoeById(itemId)
    }

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.9f),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = shoe?.shoeName ?: "Failed to find a shoe!",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}