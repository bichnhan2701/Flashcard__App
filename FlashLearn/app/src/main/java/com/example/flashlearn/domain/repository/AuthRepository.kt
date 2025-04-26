package com.example.flashlearn.domain.repository

import android.content.Context
import com.example.flashlearn.domain.model.User

interface AuthRepository {
    suspend fun loginWithGoogle(idToken: String): Result<User>
    fun getCurrentUser(): User?
    fun logout(context: Context)
}
