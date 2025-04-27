package com.example.flashlearn.data.repository

import com.example.flashlearn.data.local.dao.CategoryDao
import com.example.flashlearn.data.local.dao.FlashcardDao
import com.example.flashlearn.data.local.entity.CategoryEntity
import com.example.flashlearn.data.local.entity.FlashcardEntity
import com.example.flashlearn.data.local.mapper.toDomain
import com.example.flashlearn.data.local.mapper.toEntity
import com.example.flashlearn.domain.model.Category
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao,
    private val flashcardDao: FlashcardDao
) : CategoryRepository {
    override suspend fun createCategory(category: Category): Int {
        return categoryDao.insert(category.toEntity()).toInt()
    }

    override suspend fun addFlashcardsToCategory(categoryId: Int, flashcards: List<Flashcard>) {
        val entities = flashcards.map { it.toEntity() }
        flashcardDao.insertAll(entities)
    }

    override fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAll().map { it.map(CategoryEntity::toDomain) }
    }

    override suspend fun updateCategoryInfo(categoryId: Int, newName: String, newCardCount: Int) {
        categoryDao.updateCategoryInfo(categoryId, newName, newCardCount)
    }

    override suspend fun deleteById(categoryId: Int) {
        categoryDao.deleteById(categoryId)
    }

    override suspend fun getCategoryById(categoryId: Int): Category? {
        return categoryDao.getById(categoryId)?.toDomain()
    }

    override suspend fun getUpdatedCategories(lastSyncedAt: Long): List<Category> {
        return categoryDao.getUpdatedSince(lastSyncedAt).map { it.toDomain() }
    }

    override suspend fun deleteAllCategories() {
        categoryDao.deleteAll()
    }

    override suspend fun hasAnyCategory(): Boolean {
        return categoryDao.countCategories() > 0
    }

}