package com.example.shoe_store.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.shoe_store.data.ShoeModel
import com.example.shoe_store.data.ShoeStore
import java.util.Collections.emptyList

class MainPageViewModel : ViewModel() {
    private var hotPicks: List<ShoeModel> = emptyList()
    var homePageSearchBarIsActive by mutableStateOf(false)
        private set

    fun changeHomePageSearchBarIsActive() {
        homePageSearchBarIsActive = !homePageSearchBarIsActive
    }

    fun getHotPicks(): List<ShoeModel>{
        if(hotPicks.isEmpty()) {
            val newHotPicks = ShoeStore.getRandomShoesAsHotPicks()
            hotPicks = newHotPicks
            return hotPicks
        } else {
            return hotPicks
        }
    }
}