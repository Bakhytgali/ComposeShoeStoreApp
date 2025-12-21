package com.example.shoe_store.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.shoe_store.components.AppTopBar
import com.example.shoe_store.data.ShoeModel
import com.example.shoe_store.data.ShoeStore
import com.example.shoe_store.viewModels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopItemPage(
    user: UserViewModel,
    itemId: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var shoe: ShoeModel? by remember {
        mutableStateOf(null)
    }
    LaunchedEffect(Unit) {
        shoe = ShoeStore.getShoeById(itemId)
    }

    Scaffold(
        topBar = {
            AppTopBar(
                navIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.9f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = shoe?.shoeName ?: "Something",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}