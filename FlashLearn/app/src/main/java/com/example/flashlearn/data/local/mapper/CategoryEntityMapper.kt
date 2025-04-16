package com.example.flashlearn.data.local.mapper

import com.example.flashlearn.data.local.entity.CategoryEntity
import com.example.flashlearn.domain.model.Category

fun CategoryEntity.toDomain(): Category {
    return Category(
        id = id,
        name = name,
        cardCount = cardCount,
        isReviewed = isReviewed,
        isQuizDone = isQuizDone,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = id,
        name = name,
        cardCount = cardCount,
        isReviewed = isReviewed,
        isQuizDone = isQuizDone,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}