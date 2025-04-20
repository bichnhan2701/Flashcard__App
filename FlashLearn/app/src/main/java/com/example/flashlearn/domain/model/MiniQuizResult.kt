package com.example.flashlearn.domain.model

data class MiniQuizResult (
    val id: Int = 0,
    val categoryId: Int,         // folder ID
    val totalQuestions: Int,
    val correctAnswers: Int,
    val timestamp: Long = System.currentTimeMillis(), // thời gian hoàn thành bài quiz
    val wrongFlashcardIds: List<Int>
)