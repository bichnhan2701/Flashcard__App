package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.Category
import com.example.flashlearn.domain.repository.CategoryRepository
import javax.inject.Inject

class GetCategoryByIdUseCase @Inject constructor(
    private val repo: CategoryRepository
) {
    suspend operator fun invoke(id: Int): Category? = repo.getCategoryById(id)
}
