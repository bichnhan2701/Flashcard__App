package com.example.flashlearn.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flashlearn.data.local.entity.MiniQuizResultEntity

@Dao
interface MiniQuizResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(result: MiniQuizResultEntity)

    @Query("SELECT * FROM quiz_results WHERE categoryId = :categoryId ORDER BY timestamp DESC")
    suspend fun getResultsByCategory(categoryId: Int): List<MiniQuizResultEntity>

    @Query("SELECT * FROM quiz_results ORDER BY timestamp DESC")
    suspend fun getAllResults(): List<MiniQuizResultEntity>

    @Query("SELECT * FROM quiz_results WHERE timestamp BETWEEN :start AND :end")
    suspend fun getResultsBetween(start: Long, end: Long): List<MiniQuizResultEntity>

    @Query("SELECT * FROM quiz_results WHERE categoryId = :categoryId ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLatestResultByCategory(categoryId: Int): MiniQuizResultEntity?
}
