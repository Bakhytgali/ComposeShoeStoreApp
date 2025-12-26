package com.example.shoe_store.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.shoe_store.data.ShoeModel
import com.example.shoe_store.data.ShoeStore

class UserViewModel(): ViewModel() {
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

    fun alreadyInCard(id: String): Boolean {
        return userCart.any { shoe ->
            shoe.shoeId == id
        }
    }
}