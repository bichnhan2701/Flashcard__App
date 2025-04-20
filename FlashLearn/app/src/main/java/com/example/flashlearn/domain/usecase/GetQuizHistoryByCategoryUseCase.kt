package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.MiniQuizResult
import com.example.flashlearn.domain.repository.MiniQuizRepository
import javax.inject.Inject

class GetQuizHistoryByCategoryUseCase @Inject constructor(
    private val repo: MiniQuizRepository
) {
    suspend operator fun invoke(categoryId: Int): List<MiniQuizResult> = repo.getQuizResultsByCategory(categoryId)
}
