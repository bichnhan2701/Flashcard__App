package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.Category
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.repository.CategoryRepository
import javax.inject.Inject

class CreateCategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
){
    suspend operator fun invoke(name: String, flashcards: List<Flashcard>): Result<Int> {
        if (name.isBlank())
            return Result.failure(Exception("Tên không được để trống!"))
        if (flashcards.size < 2)
            return Result.failure(Exception("Cần ít nhất 2 flashcard!"))

        val now = System.currentTimeMillis()
        val category = Category(
            name = name,
            cardCount = flashcards.size,
            createdAt = now,
            updatedAt = now
        )

        val id = repository.createCategory(category)
        repository.addFlashcardsToCategory(id, flashcards.map { it.copy(categoryId = id) })

        return Result.success(id)
    }
}