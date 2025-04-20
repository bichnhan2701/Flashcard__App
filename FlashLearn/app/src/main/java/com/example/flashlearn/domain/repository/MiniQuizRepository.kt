package com.example.flashlearn.domain.repository

import com.example.flashlearn.domain.model.MiniQuizResult

interface MiniQuizRepository {
    suspend fun saveQuizResult(result: MiniQuizResult)
    suspend fun getQuizResultsByCategory(categoryId: Int): List<MiniQuizResult>
    // ✅ MỚI: lấy tất cả kết quả quiz
    suspend fun getAllQuizResults(): List<MiniQuizResult>
    // ✅ MỚI: lấy quiz theo khoảng thời gian
    suspend fun getResultsBetween(start: Long, end: Long): List<MiniQuizResult>
    // ✅ MỚI: lấy kết quả quiz mới nhất theo category
    suspend fun getLatestResultByCategory(categoryId: Int): MiniQuizResult?
}