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

    @Query("SELECT * FROM category ORDER BY createdAt DESC")
    fun getAll(): Flow<List<CategoryEntity>>
}