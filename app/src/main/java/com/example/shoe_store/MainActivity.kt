package com.example.shoe_store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.shoe_store.data.UserViewModel
import com.example.shoe_store.ui.theme.Shoe_storeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val user = UserViewModel("Rakhat") // should change this

        setContent {
            Shoe_storeTheme {
                AppNavigation(user = user)
            }
        }
    }
}
