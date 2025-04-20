package com.example.flashlearn.di

import com.example.flashlearn.data.repository.CategoryRepositoryImpl
import com.example.flashlearn.data.repository.FlashcardRepositoryImpl
import com.example.flashlearn.data.repository.MiniQuizRepositoryImpl
import com.example.flashlearn.domain.repository.CategoryRepository
import com.example.flashlearn.domain.repository.FlashcardRepository
import com.example.flashlearn.domain.repository.MiniQuizRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCategoryRepository(
        impl: CategoryRepositoryImpl
    ): CategoryRepository

    @Binds
    abstract fun bindFlashcardRepository(
        impl: FlashcardRepositoryImpl
    ): FlashcardRepository

    @Binds
    @Singleton
    abstract fun bindMiniQuizRepository(
        impl: MiniQuizRepositoryImpl
    ): MiniQuizRepository
}