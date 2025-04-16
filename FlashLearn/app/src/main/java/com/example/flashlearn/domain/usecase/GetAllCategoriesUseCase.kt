package com.example.flashlearn.domain.usecase

import com.example.flashlearn.domain.model.Category
import com.example.flashlearn.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    operator fun invoke(): Flow<List<Category>> = repository.getAllCategories()
}
