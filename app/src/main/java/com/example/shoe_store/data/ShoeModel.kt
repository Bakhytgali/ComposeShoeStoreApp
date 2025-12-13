package com.example.shoe_store.data

data class ShoeModel(
    val shoeId: String,
    val shoeName: String,
    val shoeImg: Int,
    val shoePrice: Int,
    val shoeIsLiked: Boolean = false,
)
