package com.example.shoe_store

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shoe_store.data.User
import com.example.shoe_store.pages.WelcomePage

@Composable
fun AppNavigation(
    user: User,
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        WelcomePage(
            user = user,
            modifier = modifier.padding(innerPadding)
        )
    }
}