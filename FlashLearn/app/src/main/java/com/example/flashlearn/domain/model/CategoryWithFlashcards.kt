package com.example.flashlearn.domain.model

data class CategoryWithFlashcards(
    val name: String,
    val flashcards: List<Flashcard>
)
