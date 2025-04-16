package com.example.flashlearn.data.repository

import com.example.flashlearn.data.local.dao.FlashcardDao
import com.example.flashlearn.data.local.mapper.toDomain
import com.example.flashlearn.data.local.mapper.toEntity
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.repository.FlashcardRepository
import javax.inject.Inject

class FlashcardRepositoryImpl @Inject constructor(
    private val dao: FlashcardDao
) : FlashcardRepository {
    override suspend fun insertAll(cards: List<Flashcard>) {
        dao.insertAll(cards.map { it.toEntity() })
    }

    override suspend fun getByCategory(categoryId: Int): List<Flashcard> {
        return dao.getByCategoryId(categoryId).map { it.toDomain() }
    }

    override suspend fun delete(card: Flashcard) {
        dao.delete(card.toEntity())
    }

    override suspend fun update(card: Flashcard) {
        dao.update(card.toEntity())
    }

    override suspend fun deleteByCategory(categoryId: Int) {
        dao.deleteByCategoryId(categoryId)
    }
}
