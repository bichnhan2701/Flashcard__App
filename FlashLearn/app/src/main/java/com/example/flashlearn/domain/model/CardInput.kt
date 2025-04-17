package com.example.flashlearn.domain.model

data class CardInput(
    val id: Int? = null,
    val term: String = "",
    val definition: String = "",
    val isFavorite: Boolean = false
)
