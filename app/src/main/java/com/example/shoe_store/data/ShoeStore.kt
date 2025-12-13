package com.example.shoe_store.data

import com.example.shoe_store.R

object ShoeStore {
    private var shoes: MutableList<ShoeModel> = mutableListOf()

    init {
        loadShoes()
    }

    fun getShoes(): List<ShoeModel> = this.shoes.ifEmpty { emptyList() }

    private fun loadShoes() {
        val shoes: MutableList<ShoeModel> = mutableListOf()

        shoes.add(
            ShoeModel(
                shoeId = ShoeIdGenerator.getRandomString(),
                shoeName = "Nike Air Max Dn",
                shoeImg = R.drawable.nike_air_max_dn,
                shoePrice = 80,
            )
        )
        shoes.add(
            ShoeModel(
                shoeId = ShoeIdGenerator.getRandomString(),
                shoeName = "Nike Air Max Dn Purple",
                shoeImg = R.drawable.nike_air_max_dn_purple,
                shoePrice = 85,
            )
        )
        shoes.add(
            ShoeModel(
                shoeId = ShoeIdGenerator.getRandomString(),
                shoeName = "Nike Air Max Dn Red",
                shoeImg = R.drawable.nike_air_max_dn_red,
                shoePrice = 85,
            )
        )
        shoes.add(
            ShoeModel(
                shoeId = ShoeIdGenerator.getRandomString(),
                shoeName = "Nike Air Max Dn Sky Blue",
                shoeImg = R.drawable.nike_air_max_dn_sky_blue,
                shoePrice = 85,
            )
        )
        shoes.add(
            ShoeModel(
                shoeId = ShoeIdGenerator.getRandomString(),
                shoeName = "Nike Journey Women's",
                shoeImg = R.drawable.nike_journey_women,
                shoePrice = 70,
            )
        )
        shoes.add(
            ShoeModel(
                shoeId = ShoeIdGenerator.getRandomString(),
                shoeName = "Nike Revolution",
                shoeImg = R.drawable.nike_revolution,
                shoePrice = 70,
            )
        )
        shoes.add(
            ShoeModel(
                shoeId = ShoeIdGenerator.getRandomString(),
                shoeName = "Nike Revolution 7",
                shoeImg = R.drawable.nike_revolution_7,
                shoePrice = 80,
            )
        )

        this.shoes = shoes
    }

    fun getShoeById(id: String): ShoeModel? {
        return if(shoes.isNotEmpty()) {
            shoes.find { shoe ->
                shoe.shoeId == id
            }
        } else {
            null
        }
    }
}