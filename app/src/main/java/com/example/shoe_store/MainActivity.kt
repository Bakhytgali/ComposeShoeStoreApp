package com.example.shoe_store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.shoe_store.viewModels.UserViewModel
import com.example.shoe_store.ui.theme.Shoe_storeTheme
import com.example.shoe_store.viewModels.MainPageViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val userViewModel = UserViewModel()
        val mainPageViewModel = MainPageViewModel()
        setContent {
            Shoe_storeTheme {
                AppNavigation(
                    user = userViewModel,
                    mainPageViewModel = mainPageViewModel
                )
            }
        }
    }
}
