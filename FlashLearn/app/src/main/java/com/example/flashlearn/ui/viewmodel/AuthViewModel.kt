package com.example.flashlearn.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.User
import com.example.flashlearn.domain.usecase.LoginWithGoogleUseCase
import com.example.flashlearn.domain.usecase.LogoutUseCase
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginWithGoogle: LoginWithGoogleUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val syncAllDataUseCase: SyncAllDataUseCase
) : ViewModel() {

    private val _authState = MutableStateFlow<Result<User>?>(null)
    val authState: StateFlow<Result<User>?> = _authState

    // Hàm đăng nhập với Google
    fun googleLogin(idToken: String) = viewModelScope.launch {
        loginWithGoogle(idToken)
            .catch { e ->
                _authState.value = Result.failure(e)
            }
            .collect { result ->
                _authState.value = result
                if (result.isSuccess) {
                    triggerSync()
                }
            }
    }

    // Hàm đăng xuất
    fun logout(context: Context) = viewModelScope.launch {
        logoutUseCase(context) // truyền context vào
        syncAllDataUseCase.resetLastSyncedAt()
        syncAllDataUseCase.clearLocalDatabase()
        _authState.value = null
    }

    private fun triggerSync() {
        viewModelScope.launch {
            Log.d("AuthViewModel", "🔥 triggerSync called after login success")
            try {
                syncAllDataUseCase.sync()
            } catch (e: Exception) {
                Log.e("Sync", "Failed to sync after login: ${e.message}")
            }
        }
    }
}