package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.MiniQuizResult
import com.example.flashlearn.domain.repository.MiniQuizRepository
import javax.inject.Inject

class SaveMiniQuizResultUseCase @Inject constructor(
    private val miniQuizRepository: MiniQuizRepository
) {
    suspend operator fun invoke(result: MiniQuizResult) {
        miniQuizRepository.saveQuizResult(result)
    }
}