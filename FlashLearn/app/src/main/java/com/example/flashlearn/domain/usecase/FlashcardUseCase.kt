package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.repository.FlashcardRepository
import javax.inject.Inject

data class FlashcardUseCases(
    val insertAll: InsertFlashcardsUseCase,
    val getByCategory: GetFlashcardsByCategoryUseCase,
    val delete: DeleteFlashcardUseCase,
    val update: UpdateFlashcardUseCase
)

class InsertFlashcardsUseCase @Inject constructor(
    private val repository: FlashcardRepository
) {
    suspend operator fun invoke(cards: List<Flashcard>) {
        repository.insertAll(cards)    }
}

class GetFlashcardsByCategoryUseCase @Inject constructor(
    private val repo: FlashcardRepository
) {
    suspend operator fun invoke(categoryId: Int) = repo.getByCategory(categoryId)
}

class DeleteFlashcardUseCase @Inject constructor(
    private val repo: FlashcardRepository
) {
    suspend operator fun invoke(card: Flashcard) = repo.delete(card)
}

class UpdateFlashcardUseCase @Inject constructor(
    private val repo: FlashcardRepository
) {
    suspend operator fun invoke(card: Flashcard) = repo.update(card)
}