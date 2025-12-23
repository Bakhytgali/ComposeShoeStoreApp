package com.example.shoe_store.data

data class ShoeModel(
    val shoeId: String,
    val shoeName: String,
    val shoeImg: Int,
    val shoePrice: Int,
    val numberSold: Int = 0,
    val reviews: List<ReviewModel> = emptyList(),
    val characteristics: List<ShoeCharacteristicsModel> = emptyList(),
    val shoeIsLiked: Boolean = false,
)
