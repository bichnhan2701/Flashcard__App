package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.CategoryProgress
import com.example.flashlearn.domain.repository.CategoryRepository
import com.example.flashlearn.domain.repository.FlashcardRepository
import com.example.flashlearn.domain.repository.MiniQuizRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetAllQuizResultsUseCase @Inject constructor(
    private val repository: MiniQuizRepository
) {
    suspend operator fun invoke() = repository.getAllQuizResults()
}

class GetQuizResultsBetweenUseCase @Inject constructor(
    private val repository: MiniQuizRepository
) {
    suspend operator fun invoke(start: Long, end: Long) =
        repository.getResultsBetween(start, end)
}

class GetLatestQuizResultByCategoryUseCase @Inject constructor(
    private val repository: MiniQuizRepository
) {
    suspend operator fun invoke(categoryId: Int) =
        repository.getLatestResultByCategory(categoryId)
}

class GetAllCategoriesProgressUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val flashcardRepository: FlashcardRepository
) {
    suspend operator fun invoke(): List<CategoryProgress> {
        val categories = categoryRepository.getAllCategories().first()
        return categories.map { category ->
            val flashcards = flashcardRepository.getByCategory(category.id)
            val remembered = flashcards.count { it.isRemembered }
            val unremembered = flashcards.size - remembered

            CategoryProgress(
                categoryId = category.id,
                categoryName = category.name,
                totalCards = flashcards.size,
                rememberedCards = remembered,
                unrememberedCards = unremembered,
                isQuizDone = category.isQuizDone
            )
        }
    }
}
