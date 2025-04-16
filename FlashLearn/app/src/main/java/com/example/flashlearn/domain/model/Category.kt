package com.example.flashlearn.domain.model

data class Category (
    val id: Int = 0,
    val name: String,
    val cardCount: Int,
    val isReviewed: Boolean = false,
    val isQuizDone: Boolean = false,
    val createdAt: Long,
    val updatedAt: Long
)