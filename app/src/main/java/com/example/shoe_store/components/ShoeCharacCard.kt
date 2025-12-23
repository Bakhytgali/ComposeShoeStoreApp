package com.example.shoe_store.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import com.example.shoe_store.data.ShoeCharacteristicsModel

@Composable
fun ShoeCharacCard(
    characteristic: ShoeCharacteristicsModel,
    modifier: Modifier = Modifier
) {
    val textColor = when {
        characteristic.metricScore >= 4.5 -> Color(0xFF5D3FD3)
        characteristic.metricScore >= 4.0 -> Color(0xFF097969)
        characteristic.metricScore >= 3.0 -> Color(0xFFFFBF00)
        else -> Color(0xFFEE4B2B)
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(5.dp),
    ) {
        Row (
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = characteristic.metricName,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = characteristic.metricScore.toString(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = Bold,
                color = textColor
            )
        }
    }
}