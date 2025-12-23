package com.example.shoe_store.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoe_store.data.ReviewModel

@Composable
fun ShoeReviewsColumn(
    reviews: List<ReviewModel> = emptyList(),
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(reviews) { review ->
            ReviewCard(review = review)
        }
    }
}