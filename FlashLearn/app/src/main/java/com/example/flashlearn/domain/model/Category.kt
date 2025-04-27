package com.example.flashlearn.domain.model

import androidx.annotation.Keep

@Keep
data class Category (
    val id: Int = 0,
    val name: String,
    val cardCount: Int,
    val isReviewed: Boolean = false,
    val isQuizDone: Boolean = false,
    val createdAt: Long,
    val updatedAt: Long
) {
    // Firebase cần constructor rỗng
    constructor() : this(0, "", 0, false, false, 0,0)
}