package com.example.shoe_store.data

object ShoeOperations {
    fun getRandomString(): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..10)
            .map {
                allowedChars.random()
            }
            .joinToString("")
    }

    fun countAvgReview(shoeModel: ShoeModel): Double {
        var avgReviewScore: Double = 0.0

        shoeModel.reviews.forEach { review ->
            avgReviewScore += review.rating
        }

        return avgReviewScore / shoeModel.reviews.size
    }
}