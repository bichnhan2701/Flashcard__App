package com.example.flashlearn.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flashlearn.data.local.dao.CategoryDao
import com.example.flashlearn.data.local.dao.FlashcardDao
import com.example.flashlearn.data.local.entity.CategoryEntity
import com.example.flashlearn.data.local.entity.FlashcardEntity

@Database(entities = [CategoryEntity::class, FlashcardEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun flashcardDao(): FlashcardDao
}
