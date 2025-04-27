package com.example.flashlearn.data.remote.model

data class FirebaseCategory(
    val id: Int = 0,
    val name: String = "",
    val cardCount: Int = 0,
    val isReviewed: Boolean = false,
    val isQuizDone: Boolean = false,
    val createdAt: Long = 0L,
    val updatedAt: Long = 0L
)

data class FirebaseFlashcard(
    val id: Int = 0,
    val categoryId: Int = 0,
    val term: String = "",
    val definition: String = "",
    val pronunciation: String?,
    val isFavorite: Boolean,
    val isRemembered: Boolean,
    val createdAt: Long = 0L,
    val updatedAt: Long = 0L,
    val lastReviewedDate: Long? = null
)

data class FirebaseMiniQuizResult(
    val id: Int = 0,
    val categoryId: Int = 0,         // folder ID
    val totalQuestions: Int = 0,
    val correctAnswers: Int = 0,
    val timestamp: Long = System.currentTimeMillis(), // thời gian hoàn thành bài quiz
    val wrongFlashcardIds: List<Int>,
    val updateAt: Long = 0L
)
