package com.example.shoe_store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.shoe_store.viewModels.UserViewModel
import com.example.shoe_store.ui.theme.Shoe_storeTheme
import com.example.shoe_store.viewModels.MainPageViewModel
import com.example.shoe_store.viewModels.SearchViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val userViewModel = UserViewModel()
        val mainPageViewModel = MainPageViewModel()
        val searchViewModel = SearchViewModel()
        setContent {
            Shoe_storeTheme {
                AppNavigation(
                    userViewModel = userViewModel,
                    mainPageViewModel = mainPageViewModel,
                    searchViewModel = searchViewModel
                )
            }
        }
    }
}
