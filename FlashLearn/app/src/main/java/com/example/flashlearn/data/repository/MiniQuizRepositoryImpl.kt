package com.example.flashlearn.data.repository

import com.example.flashlearn.data.local.dao.MiniQuizResultDao
import com.example.flashlearn.data.local.mapper.toEntity
import com.example.flashlearn.data.local.mapper.toDomain
import com.example.flashlearn.domain.model.MiniQuizResult
import com.example.flashlearn.domain.repository.MiniQuizRepository
import javax.inject.Inject

class MiniQuizRepositoryImpl @Inject constructor(
    private val dao: MiniQuizResultDao
) : MiniQuizRepository {
    override suspend fun saveQuizResult(result: MiniQuizResult) {
        dao.insert(result.toEntity())
    }

    override suspend fun getQuizResultsByCategory(categoryId: Int): List<MiniQuizResult> {
        return dao.getResultsByCategory(categoryId).map { it.toDomain() }
    }

    override suspend fun getAllQuizResults(): List<MiniQuizResult> =
        dao.getAllResults().map { it.toDomain() }

    override suspend fun getResultsBetween(start: Long, end: Long): List<MiniQuizResult> =
        dao.getResultsBetween(start, end).map { it.toDomain() }

    override suspend fun getLatestResultByCategory(categoryId: Int): MiniQuizResult? =
        dao.getLatestResultByCategory(categoryId)?.toDomain()
}
