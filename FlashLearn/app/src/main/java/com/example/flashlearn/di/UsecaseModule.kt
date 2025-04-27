package com.example.flashlearn.di

import com.example.flashlearn.data.remote.FirebaseRemoteDataSource
import com.example.flashlearn.domain.repository.AuthRepository
import com.example.flashlearn.domain.repository.CategoryRepository
import com.example.flashlearn.domain.repository.FlashcardRepository
import com.example.flashlearn.domain.repository.MiniQuizRepository
import com.example.flashlearn.domain.repository.SharedPreferencesRepository
import com.example.flashlearn.domain.usecase.*
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
    fun provideLoginWithGoogleUseCase(
        repository: AuthRepository
    ): LoginWithGoogleUseCase {
        return LoginWithGoogleUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideLogoutUseCase(
        repository: AuthRepository
    ): LogoutUseCase {
        return LogoutUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideGetAllCategoriesUseCase(
        repository: CategoryRepository
    ): GetAllCategoriesUseCase {
        return GetAllCategoriesUseCase(repository)
    }
    @Provides
    fun provideGetCategoryByIdUseCases(
        repository: CategoryRepository
    ): GetCategoryByIdUseCase {
        return GetCategoryByIdUseCase(repository)
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

    @Provides
    @Singleton
    fun provideSyncAllDataUseCase(
        categoryRepository: CategoryRepository,
        flashcardRepository: FlashcardRepository,
        miniQuizRepository: MiniQuizRepository,
        firebaseRemoteDataSource: FirebaseRemoteDataSource,
        sharedPreferencesRepository: SharedPreferencesRepository
    ): SyncAllDataUseCase {
        return SyncAllDataUseCase(
            categoryRepository,
            flashcardRepository,
            miniQuizRepository,
            firebaseRemoteDataSource,
            sharedPreferencesRepository
        )
    }

}