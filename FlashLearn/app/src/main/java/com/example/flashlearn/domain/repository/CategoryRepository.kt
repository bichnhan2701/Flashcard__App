package com.example.flashlearn.domain.repository

import com.example.flashlearn.domain.model.Category
import com.example.flashlearn.domain.model.Flashcard
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun createCategory(category: Category): Int
    suspend fun addFlashcardsToCategory(categoryId: Int, flashcards: List<Flashcard>)
    fun getAllCategories(): Flow<List<Category>>
    suspend fun updateCategoryInfo(categoryId: Int, newName: String, newCardCount: Int)
    suspend fun deleteById(categoryId: Int)
    suspend fun getCategoryById(categoryId: Int): Category?
    suspend fun getUpdatedCategories(lastSyncedAt: Long): List<Category>
    suspend fun deleteAllCategories()
    suspend fun hasAnyCategory(): Boolean

}