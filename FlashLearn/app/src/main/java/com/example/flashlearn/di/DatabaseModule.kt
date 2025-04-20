package com.example.flashlearn.di

import android.content.Context
import androidx.room.Room
import com.example.flashlearn.data.local.AppDatabase
import com.example.flashlearn.data.local.dao.CategoryDao
import com.example.flashlearn.data.local.dao.FlashcardDao
import com.example.flashlearn.data.local.dao.MiniQuizResultDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "flash_learn_db"
        )
            .fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideCategoryDao(database: AppDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    @Singleton
    fun provideFlashcardDao(database: AppDatabase): FlashcardDao {
        return database.flashcardDao()
    }

    @Provides
    @Singleton
    fun provideMiniQuizDao(database: AppDatabase): MiniQuizResultDao {
        return database.miniQuizResultDao()
    }
}