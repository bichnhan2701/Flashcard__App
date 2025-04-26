package com.example.flashlearn.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.User
import com.example.flashlearn.domain.usecase.LoginWithGoogleUseCase
import com.example.flashlearn.domain.usecase.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginWithGoogle: LoginWithGoogleUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {

    private val _authState = MutableStateFlow<Result<User>?>(null)
    val authState: StateFlow<Result<User>?> = _authState

    // Hàm đăng nhập với Google
    fun googleLogin(idToken: String) = viewModelScope.launch {
        loginWithGoogle(idToken)
            .catch { e -> _authState.value = Result.failure(e) }  // Bắt lỗi từ bên ngoài
            .collect { result -> _authState.value = result }  // Cập nhật state khi có kết quả
    }

    // Hàm đăng xuất
    fun logout(context: Context) = viewModelScope.launch {
        logoutUseCase(context) // truyền context vào
        _authState.value = null
    }
}