package com.example.flashlearn.utils

import com.example.flashlearn.domain.model.Flashcard

fun defaultFlashcards(count: Int = 2): List<Flashcard> {
    val now = System.currentTimeMillis()
    return List(count) {
        Flashcard(
            id = 0,
            categoryId = 0,
            term = "",
            definition = "",
            pronunciation = null,
            isFavorite = false,
            createdAt = now,
            updatedAt = now
        )
    }
}
