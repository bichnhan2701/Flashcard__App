package com.example.flashlearn.data.repository

import com.example.flashlearn.data.local.dao.CategoryDao
import com.example.flashlearn.data.local.dao.FlashcardDao
import com.example.flashlearn.data.local.entity.CategoryEntity
import com.example.flashlearn.data.local.entity.FlashcardEntity
import com.example.flashlearn.data.local.mapper.toDomain
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
        val entity = CategoryEntity(
            name = category.name,
            cardCount = category.cardCount,
            isReviewed = category.isReviewed,
            isQuizDone = category.isQuizDone,
            createdAt = category.createdAt,
            updatedAt = category.updatedAt
        )
        return categoryDao.insert(entity).toInt()
    }

    override suspend fun addFlashcardsToCategory(categoryId: Int, flashcards: List<Flashcard>) {
        val entities = flashcards.map {
            FlashcardEntity(
                categoryId = categoryId,
                term = it.term,
                definition = it.definition,
                pronunciation = it.pronunciation,
                isFavorite = it.isFavorite,
                isRemembered = it.isRemembered,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }
        flashcardDao.insertAll(entities)
    }

    override fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAll().map { it.map(CategoryEntity::toDomain) }
    }

    override suspend fun updateName(categoryId: Int, newName: String) {
        categoryDao.updateCategoryName(categoryId, newName)
    }

    override suspend fun deleteById(categoryId: Int) {
        categoryDao.deleteById(categoryId)
    }

    override suspend fun getCategoryById(categoryId: Int): Category? {
        return categoryDao.getById(categoryId)?.toDomain()
    }
}