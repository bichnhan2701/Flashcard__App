package com.example.flashlearn.data.local.mapper

import com.example.flashlearn.data.local.entity.FlashcardEntity
import com.example.flashlearn.domain.model.Flashcard

fun FlashcardEntity.toDomain() = Flashcard(
    id, categoryId, term, definition, pronunciation, isFavorite, createdAt, updatedAt
)

fun Flashcard.toEntity() = FlashcardEntity(
    id, categoryId, term, definition, pronunciation, isFavorite, createdAt, updatedAt
)
