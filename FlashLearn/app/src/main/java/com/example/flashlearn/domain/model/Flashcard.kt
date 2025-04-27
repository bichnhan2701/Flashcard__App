package com.example.flashlearn.domain.model

import androidx.annotation.Keep

@Keep
data class Flashcard(
    val id: Int = 0,
    val categoryId: Int,
    val term: String,
    val definition: String,
    val pronunciation: String?,
    val isFavorite: Boolean,
    val isRemembered: Boolean,
    val createdAt: Long,
    val updatedAt: Long,
    val lastReviewedDate: Long? = null
) {
    constructor() : this(0,0,"","","",false,false,0L, 0L)
}