package com.example.flashlearn.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_results")
data class MiniQuizResultEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val categoryId: Int,
    val totalQuestions: Int,
    val correctAnswers: Int,
    val timestamp: Long,
    val wrongFlashcardIds: List<Int>
)
