package com.example.shoe_store.data

class User(val name: String) {
    private val userCart: MutableList<ShoeModel> = mutableListOf()

    fun getCart(): List<ShoeModel> = userCart.ifEmpty { emptyList() }

    fun addShoeToCart(id: String): String {
        val shoe: ShoeModel? = ShoeStore.getShoeById(id)

        if(shoe != null && userCart.isNotEmpty() && !alreadyInCard(id = id)) {
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