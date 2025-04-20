package com.example.flashlearn.data.local.mapper

import com.example.flashlearn.data.local.entity.MiniQuizResultEntity
import com.example.flashlearn.domain.model.MiniQuizResult

fun MiniQuizResult.toEntity() = MiniQuizResultEntity(
    id = id,
    categoryId = categoryId,
    totalQuestions = totalQuestions,
    correctAnswers = correctAnswers,
    timestamp = timestamp,
    wrongFlashcardIds = wrongFlashcardIds
)

fun MiniQuizResultEntity.toDomain() = MiniQuizResult(
    id = id,
    categoryId = categoryId,
    totalQuestions = totalQuestions,
    correctAnswers = correctAnswers,
    timestamp = timestamp,
    wrongFlashcardIds = wrongFlashcardIds
)
