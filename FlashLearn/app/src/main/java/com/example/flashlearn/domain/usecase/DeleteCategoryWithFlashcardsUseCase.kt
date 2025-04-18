package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.repository.CategoryRepository
import com.example.flashlearn.domain.repository.FlashcardRepository

class DeleteCategoryWithFlashcardsUseCase(
    private val flashcardRepository: FlashcardRepository,
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(categoryId: Int) {
        flashcardRepository.deleteByCategory(categoryId)
        categoryRepository.deleteById(categoryId)
    }
}
