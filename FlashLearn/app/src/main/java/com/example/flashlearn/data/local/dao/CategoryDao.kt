package com.example.flashlearn.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.flashlearn.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao{
    @Insert
    suspend fun insert(category: CategoryEntity): Long

    @Query("""
        SELECT 
            c.id, 
            c.name, 
            c.isReviewed, 
            c.isQuizDone, 
            c.createdAt, 
            c.updatedAt,
            COUNT(f.id) AS cardCount
        FROM category c
        LEFT JOIN flashcard f ON c.id = f.categoryId
        GROUP BY c.id
        ORDER BY c.createdAt DESC
    """)
    fun getAll(): Flow<List<CategoryEntity>>

    @Query("UPDATE category SET name = :newName, cardCount = :newCardCount WHERE id = :categoryId")
    suspend fun updateCategoryInfo(categoryId: Int, newName: String, newCardCount: Int)


    @Query("DELETE FROM category WHERE id = :categoryId")
    suspend fun deleteById(categoryId: Int)

    @Query("SELECT * FROM category WHERE id = :categoryId LIMIT 1")
    suspend fun getById(categoryId: Int): CategoryEntity?

    @Query("UPDATE category SET name = :newName WHERE id = :categoryId")
    suspend fun updateCategoryName(categoryId: Int, newName: String)

    // Cac ham sau phuc vu cho chuc nang dong bo du lieu len Firebase Realtime Database
    @Query("SELECT * FROM category WHERE updatedAt > :lastSyncedAt")
    suspend fun getUpdatedSince(lastSyncedAt: Long): List<CategoryEntity>

    @Query("DELETE FROM category")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM category")
    suspend fun countCategories(): Int
}