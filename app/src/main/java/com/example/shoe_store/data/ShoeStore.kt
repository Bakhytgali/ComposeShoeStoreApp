package com.example.shoe_store.data

import com.example.shoe_store.R
import kotlin.random.Random

object ShoeStore {
    private var shoes: MutableList<ShoeModel> = mutableListOf()

    init {
        loadShoes()
    }

    fun getShoes(): List<ShoeModel> = this.shoes.ifEmpty { emptyList() }

    fun getRandomShoesAsHotPicks(): List<ShoeModel> {
        val shoes = getShoes()
        val hotPicks: MutableList<ShoeModel> = mutableListOf()

        while(hotPicks.size < 3) {
            val randIndex = Random.nextInt(shoes.size)

            if(!hotPicks.contains(shoes[randIndex])) {
                hotPicks.add(shoes[randIndex])
            }
        }

        return hotPicks
    }

    private fun generateRandomCharacteristics(): List<ShoeCharacteristicsModel> {
        return listOf(
            ShoeCharacteristicsModel("Comfort", (3..5).random().toDouble()),
            ShoeCharacteristicsModel("Durability", (3..5).random().toDouble()),
            ShoeCharacteristicsModel("Water resistance", (2..5).random().toDouble()),
            ShoeCharacteristicsModel("Flexibility", (3..5).random().toDouble()),
        )
    }

    private fun generateRandomReviews(): List<ReviewModel> {
        val names = listOf(
            "Rakhat",
            "Bexultan",
            "Azamat",
            "Merey",
            "Damir",
            "Abylay",
            "Arailym",
            "Rasul",
            "Akbota",
            "Janerke"
        )

        val comments = listOf(
            "Very comfortable shoes!",
            "Good value for the price.",
            "Looks great and feels great.",
            "Would buy again.",
            "Not bad, but expected more."
        )

        return List((1..4).random()) {
            ReviewModel(
                authorName = names.random(),
                comment = comments.random(),
                rating = (3..5).random()
            )
        }
    }



    private fun loadShoes() {
        val shoes: MutableList<ShoeModel> = mutableListOf()

        shoes.add(
            ShoeModel(
                shoeId = ShoeOperations.getRandomString(),
                shoeName = "Nike Air Max Dn",
                shoeImg = R.drawable.nike_air_max_dn,
                shoePrice = 80,
                numberSold = (500..2000).random(),
                reviews = generateRandomReviews(),
                characteristics = generateRandomCharacteristics()
            )
        )

        shoes.add(
            ShoeModel(
                shoeId = ShoeOperations.getRandomString(),
                shoeName = "Nike Air Max Dn Purple",
                shoeImg = R.drawable.nike_air_max_dn_purple,
                shoePrice = 85,
                numberSold = (400..1800).random(),
                reviews = generateRandomReviews(),
                characteristics = generateRandomCharacteristics()
            )
        )

        shoes.add(
            ShoeModel(
                shoeId = ShoeOperations.getRandomString(),
                shoeName = "Nike Air Max Dn Red",
                shoeImg = R.drawable.nike_air_max_dn_red,
                shoePrice = 85,
                numberSold = (300..1500).random(),
                reviews = generateRandomReviews(),
                characteristics = generateRandomCharacteristics()
            )
        )

        shoes.add(
            ShoeModel(
                shoeId = ShoeOperations.getRandomString(),
                shoeName = "Nike Air Max Dn Sky Blue",
                shoeImg = R.drawable.nike_air_max_dn_sky_blue,
                shoePrice = 85,
                numberSold = (300..1400).random(),
                reviews = generateRandomReviews(),
                characteristics = generateRandomCharacteristics()
            )
        )

        shoes.add(
            ShoeModel(
                shoeId = ShoeOperations.getRandomString(),
                shoeName = "Nike Journey Women's",
                shoeImg = R.drawable.nike_journey_women,
                shoePrice = 70,
                numberSold = (600..2500).random(),
                reviews = generateRandomReviews(),
                characteristics = generateRandomCharacteristics()
            )
        )

        shoes.add(
            ShoeModel(
                shoeId = ShoeOperations.getRandomString(),
                shoeName = "Nike Revolution",
                shoeImg = R.drawable.nike_revolution,
                shoePrice = 70,
                numberSold = (700..3000).random(),
                reviews = generateRandomReviews(),
                characteristics = generateRandomCharacteristics()
            )
        )

        shoes.add(
            ShoeModel(
                shoeId = ShoeOperations.getRandomString(),
                shoeName = "Nike Revolution 7",
                shoeImg = R.drawable.nike_revolution_7,
                shoePrice = 80,
                numberSold = (800..3500).random(),
                reviews = generateRandomReviews(),
                characteristics = generateRandomCharacteristics()
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