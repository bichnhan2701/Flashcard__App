package com.example.flashlearn.data.local.mapper

import com.example.flashlearn.data.remote.model.FirebaseCategory
import com.example.flashlearn.data.remote.model.FirebaseFlashcard
import com.example.flashlearn.data.remote.model.FirebaseMiniQuizResult
import com.example.flashlearn.domain.model.Category
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.model.MiniQuizResult

fun Category.toFirebaseModel(): FirebaseCategory {
    return FirebaseCategory(
        id = id,
        name = name,
        cardCount = cardCount,
        isReviewed = isReviewed,
        isQuizDone = isQuizDone,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun Flashcard.toFirebaseModel(): FirebaseFlashcard {
    return FirebaseFlashcard(
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
}

fun MiniQuizResult.toFirebaseModel(): FirebaseMiniQuizResult {
    return FirebaseMiniQuizResult(
        id = id,
        categoryId = categoryId,
        correctAnswers = correctAnswers,
        totalQuestions = totalQuestions,
        timestamp = timestamp,
        wrongFlashcardIds = wrongFlashcardIds,
        updateAt = updateAt
    )
}
