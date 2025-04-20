package com.example.flashlearn.domain.model

data class CategoryProgress(
    val categoryId: Int,
    val categoryName: String,
    val totalCards: Int,
    val rememberedCards: Int,
    val unrememberedCards: Int,
    val isQuizDone: Boolean
)
