package com.example.flashlearn.data.local.mapper

import com.example.flashlearn.domain.model.CardInput
import com.example.flashlearn.domain.model.Flashcard

private val now = System.currentTimeMillis()

// Chuyển từ CardInput sang Flashcard
fun CardInput.toFlashcard(categoryId: Int): Flashcard {
    return Flashcard(
        id = this.id ?: 0,
        categoryId = categoryId,
        term = this.term,
        pronunciation = null,
        definition = this.definition,
        isFavorite = this.isFavorite,
        createdAt = now,
        updatedAt = now
    )
}

// Chuyển từ Flashcard sang CardInput
fun Flashcard.toCardInput(): CardInput {
    return CardInput(
        id = this.id,
        term = this.term,
        definition = this.definition,
        isFavorite = this.isFavorite
    )
}