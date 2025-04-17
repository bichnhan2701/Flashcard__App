package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.FolderWithFlashcards
import com.example.flashlearn.domain.repository.CategoryRepository
import com.example.flashlearn.domain.repository.FlashcardRepository
import javax.inject.Inject

class GetFolderWithFlashcardsUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val flashcardRepository: FlashcardRepository
) {
    suspend operator fun invoke(categoryId: Int): FolderWithFlashcards {
//        val categories = categoryRepository.getAllCategories()
        val name = categoryRepository.getCategoryById(categoryId)?.name ?: ""

        val flashcards = flashcardRepository.getByCategory(categoryId)

        return FolderWithFlashcards(
            name = name,
            flashcards = flashcards
        )
    }
}
