package com.example.flashlearn.domain.usecase

import android.content.Context
import com.example.flashlearn.domain.model.User
import com.example.flashlearn.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginWithGoogleUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(idToken: String): Flow<Result<User>> = flow {
        val result = repository.loginWithGoogle(idToken)
        emit(result)
    }.catch { e ->
        emit(Result.failure(Exception("Đăng nhập Google thất bại: ${e.localizedMessage}")))
    }
}

class LogoutUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(context: Context) {
        repository.logout(context)
    }
}
