package com.example.shoe_store

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainPageViewModel : ViewModel() {
    var homePageSearchBarIsActive by mutableStateOf(false)
        private set

    fun changeHomePageSearchBarIsActive() {
        homePageSearchBarIsActive = !homePageSearchBarIsActive
    }
}