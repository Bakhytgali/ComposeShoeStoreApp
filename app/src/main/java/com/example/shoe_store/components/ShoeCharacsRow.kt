package com.example.shoe_store.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoe_store.data.ShoeCharacteristicsModel

@Composable
fun ShoeCharacsRow(
    characteristic: List<ShoeCharacteristicsModel>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(characteristic) { shoeCharateristic ->
            ShoeCharacCard(characteristic = shoeCharateristic)
        }
    }
}