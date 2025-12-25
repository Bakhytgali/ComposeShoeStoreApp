package com.example.shoe_store.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.shoe_store.data.ShoeModel
import com.example.shoe_store.data.ShoeStore

class SearchViewModel: ViewModel() {
    var searchValue by mutableStateOf("")
        private set

    private var allShoes = ShoeStore.getShoes()
    var searchShoes by mutableStateOf<List<ShoeModel>>(emptyList())
        private set

    fun inputSearchField(newValue: String) {
        searchValue = newValue

        searchShoes = if(searchValue.isNotBlank()) {
            allShoes.filter {
                it.shoeName.contains(searchValue, ignoreCase = true)
            }
        } else {
            emptyList()
        }
    }
}