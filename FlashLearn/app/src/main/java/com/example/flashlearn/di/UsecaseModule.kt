package com.example.flashlearn.di

import com.example.flashlearn.domain.repository.CategoryRepository
import com.example.flashlearn.domain.repository.FlashcardRepository
import com.example.flashlearn.domain.usecase.CreateCategoryUseCase
import com.example.flashlearn.domain.usecase.DeleteFlashcardUseCase
import com.example.flashlearn.domain.usecase.DeleteFolderWithFlashcardsUseCase
import com.example.flashlearn.domain.usecase.FlashcardUseCases
import com.example.flashlearn.domain.usecase.GetAllCategoriesUseCase
import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase
import com.example.flashlearn.domain.usecase.GetFolderWithFlashcardsUseCase
import com.example.flashlearn.domain.usecase.InsertFlashcardsUseCase
import com.example.flashlearn.domain.usecase.UpdateFlashcardUseCase
import com.example.flashlearn.domain.usecase.UpdateFolderWithFlashcardsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetAllCategoriesUseCase(
        repository: CategoryRepository
    ): GetAllCategoriesUseCase {
        return GetAllCategoriesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCreateCategoryUseCase(
        repository: CategoryRepository
    ): CreateCategoryUseCase {
        return CreateCategoryUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideFlashcardUseCases(
        insertFlashcardsUseCase: InsertFlashcardsUseCase,
        getFlashcardsByCategoryUseCase: GetFlashcardsByCategoryUseCase,
        deleteFlashcardUseCase: DeleteFlashcardUseCase,
        updateFlashcardUseCase: UpdateFlashcardUseCase
    ): FlashcardUseCases {
        return FlashcardUseCases(
            insertAll = insertFlashcardsUseCase,
            getByCategory = getFlashcardsByCategoryUseCase,
            delete = deleteFlashcardUseCase,
            update = updateFlashcardUseCase
        )
    }

    @Provides
    @Singleton
    fun provideGetFolderWithFlashcardsUseCase(
        categoryRepository: CategoryRepository,
        flashcardRepository: FlashcardRepository
    ): GetFolderWithFlashcardsUseCase {
        return GetFolderWithFlashcardsUseCase(categoryRepository, flashcardRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateFolderWithFlashcardsUseCase(
        flashcardRepository: FlashcardRepository,
        categoryRepository: CategoryRepository
    ): UpdateFolderWithFlashcardsUseCase {
        return UpdateFolderWithFlashcardsUseCase(categoryRepository, flashcardRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteFolderWithFlashcardsUseCase(
        flashcardRepository: FlashcardRepository,
        categoryRepository: CategoryRepository
    ): DeleteFolderWithFlashcardsUseCase {
        return DeleteFolderWithFlashcardsUseCase(flashcardRepository, categoryRepository)
    }
}
