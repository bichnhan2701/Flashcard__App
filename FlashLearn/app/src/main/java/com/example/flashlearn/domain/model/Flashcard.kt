package com.example.flashlearn.domain.model

data class Flashcard(
    val id: Int = 0,
    val categoryId: Int,
    val term: String,
    val definition: String,
    val pronunciation: String?,
    val isFavorite: Boolean,
    val createdAt: Long,
    val updatedAt: Long
)