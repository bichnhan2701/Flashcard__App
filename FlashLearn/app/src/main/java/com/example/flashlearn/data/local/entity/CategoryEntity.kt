package com.example.flashlearn.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "category" )
data class CategoryEntity(
    @PrimaryKey( autoGenerate = true ) val id: Int = 0,
    val name: String,
    val cardCount: Int,
    val isReviewed: Boolean,
    val isQuizDone: Boolean,
    val createdAt: Long,
    val updatedAt: Long
)