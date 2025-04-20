package com.example.flashlearn.domain.model

data class MiniQuizQuestion (
    val flashcardId: Int,
    val definition: String,
    val options: List<String>,
    val correctAnswer: String
)