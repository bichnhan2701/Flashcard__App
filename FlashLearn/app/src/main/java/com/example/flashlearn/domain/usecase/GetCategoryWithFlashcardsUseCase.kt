package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.CategoryWithFlashcards
import com.example.flashlearn.domain.repository.CategoryRepository
import com.example.flashlearn.domain.repository.FlashcardRepository
import javax.inject.Inject

class GetCategoryWithFlashcardsUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val flashcardRepository: FlashcardRepository
) {
    suspend operator fun invoke(categoryId: Int): CategoryWithFlashcards {
        val name = categoryRepository.getCategoryById(categoryId)?.name ?: ""
        val flashcards = flashcardRepository.getByCategory(categoryId)

        return CategoryWithFlashcards(
            name = name,
            flashcards = flashcards
        )
    }
}
