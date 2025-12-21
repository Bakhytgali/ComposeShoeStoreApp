package com.example.shoe_store.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlin.collections.emptyList

class UserViewModel(val name: String): ViewModel() {
    private var userCart = mutableStateListOf<ShoeModel>()

    fun getCartSize(): Int = getCart().size
    fun getCart(): List<ShoeModel> = userCart

    fun addShoeToCart(id: String): String {
        val shoe: ShoeModel? = ShoeStore.getShoeById(id)

        if(shoe != null && !alreadyInCard(id = id)) {
            userCart.add(shoe)
            return "OK"
        }

        return "ERROR"
    }
    fun removeShoeFromCart(id: String): String {
        val shoe: ShoeModel? = ShoeStore.getShoeById(id)

        if(shoe != null && userCart.isNotEmpty() && alreadyInCard(id = id)) {
            userCart.remove(shoe)
            return "OK"
        }
        return "ERROR"
    }

    private fun alreadyInCard(id: String): Boolean {
        return userCart.any { shoe ->
            shoe.shoeId == id
        }
    }
}