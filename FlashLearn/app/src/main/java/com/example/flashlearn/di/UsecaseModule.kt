package com.example.flashlearn.di

import com.example.flashlearn.domain.repository.CategoryRepository
import com.example.flashlearn.domain.repository.FlashcardRepository
import com.example.flashlearn.domain.repository.MiniQuizRepository
import com.example.flashlearn.domain.usecase.CreateCategoryUseCase
import com.example.flashlearn.domain.usecase.DeleteFlashcardUseCase
import com.example.flashlearn.domain.usecase.DeleteCategoryWithFlashcardsUseCase
import com.example.flashlearn.domain.usecase.FlashcardUseCases
import com.example.flashlearn.domain.usecase.GenerateMiniQuizQuestionsUseCase
import com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase
import com.example.flashlearn.domain.usecase.GetAllCategoriesUseCase
import com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase
import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase
import com.example.flashlearn.domain.usecase.GetCategoryWithFlashcardsUseCase
import com.example.flashlearn.domain.usecase.GetLatestQuizResultByCategoryUseCase
import com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase
import com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase
import com.example.flashlearn.domain.usecase.InsertFlashcardsUseCase
import com.example.flashlearn.domain.usecase.SaveMiniQuizResultUseCase
import com.example.flashlearn.domain.usecase.UpdateFlashcardUseCase
import com.example.flashlearn.domain.usecase.UpdateCategoryWithFlashcardsUseCase
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
    ): GetCategoryWithFlashcardsUseCase {
        return GetCategoryWithFlashcardsUseCase(categoryRepository, flashcardRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateFolderWithFlashcardsUseCase(
        flashcardRepository: FlashcardRepository,
        categoryRepository: CategoryRepository
    ): UpdateCategoryWithFlashcardsUseCase {
        return UpdateCategoryWithFlashcardsUseCase(categoryRepository, flashcardRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteFolderWithFlashcardsUseCase(
        flashcardRepository: FlashcardRepository,
        categoryRepository: CategoryRepository
    ): DeleteCategoryWithFlashcardsUseCase {
        return DeleteCategoryWithFlashcardsUseCase(flashcardRepository, categoryRepository)
    }

    @Provides
    @Singleton
    fun provideGenerateMiniQuizQuestionsUseCase(): GenerateMiniQuizQuestionsUseCase {
        return GenerateMiniQuizQuestionsUseCase()
    }

    @Provides
    @Singleton
    fun provideGetQuizHistoryByCategoryUseCase(
        miniQuizRepository: MiniQuizRepository
    ): GetQuizHistoryByCategoryUseCase {
        return GetQuizHistoryByCategoryUseCase(miniQuizRepository)
    }

    @Provides
    @Singleton
    fun provideSaveMiniQuizResultUseCase(
        miniQuizRepository: MiniQuizRepository
    ): SaveMiniQuizResultUseCase {
        return SaveMiniQuizResultUseCase(miniQuizRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllQuizResultsUseCase(
        miniQuizRepository: MiniQuizRepository
    ): GetAllQuizResultsUseCase {
        return GetAllQuizResultsUseCase(miniQuizRepository)
    }

    @Provides
    @Singleton
    fun provideGetQuizResultsBetweenUseCase(
        miniQuizRepository: MiniQuizRepository
    ): GetQuizResultsBetweenUseCase {
        return GetQuizResultsBetweenUseCase(miniQuizRepository)
    }

    @Provides
    @Singleton
    fun provideGetLatestQuizResultByCategoryUseCase(
        miniQuizRepository: MiniQuizRepository
    ): GetLatestQuizResultByCategoryUseCase {
        return GetLatestQuizResultByCategoryUseCase(miniQuizRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllCategoriesProgressUseCase(
        categoryRepository: CategoryRepository,
        flashcardRepository: FlashcardRepository
    ): GetAllCategoriesProgressUseCase {
        return GetAllCategoriesProgressUseCase(categoryRepository, flashcardRepository)
    }

}
