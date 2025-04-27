package com.example.flashlearn.domain.model

data class FirebaseDataBundle(
    val categories: List<Category>,
    val flashcards: List<Flashcard>,
    val miniQuizResults: List<MiniQuizResult>
)