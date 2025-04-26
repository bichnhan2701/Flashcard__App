package com.example.flashlearn.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.flashlearn.data.local.dao.CategoryDao
import com.example.flashlearn.data.local.dao.FlashcardDao
import com.example.flashlearn.data.local.dao.MiniQuizResultDao
import com.example.flashlearn.data.local.entity.CategoryEntity
import com.example.flashlearn.data.local.entity.FlashcardEntity
import com.example.flashlearn.data.local.entity.MiniQuizResultEntity

@Database(
    entities = [
        FlashcardEntity::class,
        CategoryEntity::class,
        MiniQuizResultEntity::class],
    version = 8,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun flashcardDao(): FlashcardDao
    abstract fun miniQuizResultDao(): MiniQuizResultDao
}
