package com.example.flashlearn.domain.repository

import com.example.flashlearn.domain.model.Flashcard

interface FlashcardRepository {
    suspend fun insertAll(cards: List<Flashcard>)
    suspend fun getByCategory(categoryId: Int): List<Flashcard>
    suspend fun delete(card: Flashcard)
    suspend fun update(card: Flashcard)
    suspend fun deleteByCategory(categoryId: Int)
}