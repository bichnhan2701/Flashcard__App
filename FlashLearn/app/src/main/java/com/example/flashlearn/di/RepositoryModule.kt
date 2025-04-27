package com.example.flashlearn.di

import com.example.flashlearn.data.repository.*
import com.example.flashlearn.domain.repository.*
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

    @Binds
    @Singleton
    abstract fun bindSharedPreferencesRepository(
        impl: SharedPreferencesRepositoryImpl
    ): SharedPreferencesRepository

}