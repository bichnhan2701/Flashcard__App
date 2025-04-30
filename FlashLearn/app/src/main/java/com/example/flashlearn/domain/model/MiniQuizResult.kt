package com.example.flashlearn.domain.model

data class MiniQuizResult (
    val id: Int = 0,
    val categoryId: Int,         // folder ID
    val totalQuestions: Int,
    val correctAnswers: Int,
    val timestamp: Long = System.currentTimeMillis(), // thời gian hoàn thành bài quiz
    val wrongFlashcardIds: List<Int>,
    val updateAt: Long
) {
    constructor() : this(
        id = 0,
        categoryId = 0,
        totalQuestions = 0,
        correctAnswers = 0,
        timestamp = 0L,
        wrongFlashcardIds = emptyList(),
        updateAt = 0L
    )
}