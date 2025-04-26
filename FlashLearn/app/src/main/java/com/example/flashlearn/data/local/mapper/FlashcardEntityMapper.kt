package com.example.flashlearn.data.local.mapper

import com.example.flashlearn.data.local.entity.FlashcardEntity
import com.example.flashlearn.domain.model.Flashcard

fun FlashcardEntity.toDomain() = Flashcard(
    id = id,
    categoryId = categoryId,
    term = term,
    definition = definition,
    pronunciation = pronunciation,
    isFavorite = isFavorite,
    isRemembered = isRemembered,
    createdAt = createdAt,
    updatedAt = updatedAt,
    lastReviewedDate = lastReviewedDate
)

fun Flashcard.toEntity() = FlashcardEntity(
    id = id,
    categoryId = categoryId,
    term = term,
    definition = definition,
    pronunciation = pronunciation,
    isFavorite = isFavorite,
    isRemembered = isRemembered,
    createdAt = createdAt,
    updatedAt = updatedAt,
    lastReviewedDate = lastReviewedDate
)