package com.example.flashlearn.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.flashlearn.data.local.entity.FlashcardEntity

@Dao
interface FlashcardDao {
    @Insert
    suspend fun insertAll(cards: List<FlashcardEntity>)

    @Insert
    suspend fun insert(card: FlashcardEntity)

    @Query("SELECT * FROM flashcard WHERE categoryId = :categoryId")
    suspend fun getByCategoryId(categoryId: Int): List<FlashcardEntity>

    @Delete
    suspend fun delete(card: FlashcardEntity)

    @Query("DELETE FROM flashcard WHERE categoryId = :categoryId")
    suspend fun deleteByCategoryId(categoryId: Int)

    @Update
    suspend fun update(card: FlashcardEntity)

    // Cac ham sau phuc vu cho chuc nang dong bo du lieu len Firebase Realtime Database
    @Query("SELECT * FROM flashcard WHERE updatedAt > :lastSyncedAt")
    suspend fun getUpdatedSince(lastSyncedAt: Long): List<FlashcardEntity>

    @Query("DELETE FROM flashcard")
    suspend fun deleteAll()
}