package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.repository.CategoryRepository
import com.example.flashlearn.domain.repository.FlashcardRepository
import javax.inject.Inject

class UpdateCategoryWithFlashcardsUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val flashcardRepository: FlashcardRepository
)  {
    suspend operator fun invoke(
        categoryId: Int,
        newName: String,
        updatedCards: List<Flashcard>
    ) {
        categoryRepository.updateName(categoryId, newName)

        val oldCards = flashcardRepository.getByCategory(categoryId)

        val updatedMap = updatedCards.associateBy { it.id }
        val oldMap = oldCards.associateBy { it.id }

        // Cập nhật hoặc thêm
        updatedCards.forEach { card ->
            if (card.id == 0 || oldMap[card.id] == null) {
                flashcardRepository.insertAll(listOf(card))
            } else if (card != oldMap[card.id]) {
                flashcardRepository.update(card)
            }
        }

        // Xoá flashcard không còn trong danh sách
        val toDelete = oldCards.filter { it.id !in updatedMap.keys }
        toDelete.forEach { flashcardRepository.delete(it) }
    }
}
