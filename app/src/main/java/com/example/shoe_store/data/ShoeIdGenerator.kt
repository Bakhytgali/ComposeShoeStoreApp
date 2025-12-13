package com.example.shoe_store.data

object ShoeIdGenerator {
    fun getRandomString(): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..10)
            .map {
                allowedChars.random()
            }
            .joinToString("")
    }
}