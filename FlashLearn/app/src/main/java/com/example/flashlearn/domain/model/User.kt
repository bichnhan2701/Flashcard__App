package com.example.flashlearn.domain.model

data class User(
    val id: String,
    val email: String?,
    val displayName: String?,
    val photoUrl: String? // Thêm thuộc tính cho ảnh đại diện
)
