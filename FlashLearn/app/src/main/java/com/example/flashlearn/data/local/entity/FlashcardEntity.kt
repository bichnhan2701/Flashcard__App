package com.example.flashlearn.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "flashcard" )
data class FlashcardEntity(
    @PrimaryKey( autoGenerate = true ) val id: Int = 0,
    val categoryId: Int,
    val term: String,
    val definition: String,
    val pronunciation: String?,
    val isFavorite: Boolean,
    val isRemembered: Boolean,
    val createdAt: Long,
    val updatedAt: Long,
    val lastReviewedDate: Long? = null
)