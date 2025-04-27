package com.example.flashlearn.ui.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.CreateCategoryUseCase
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFolderViewModel @Inject constructor(
    private val createCategoryUseCase: CreateCategoryUseCase,
    private val syncAllDataUseCase: SyncAllDataUseCase
) : UnsavedChangesViewModel() {

    private val _state = MutableStateFlow<CreateFolderState>(CreateFolderState.Idle)
    val state: StateFlow<CreateFolderState> = _state

    fun createFolder(name: String, flashcards: List<Flashcard>) {
        viewModelScope.launch {
            _state.value = CreateFolderState.Loading
            val result = createCategoryUseCase(name, flashcards)
            _state.value = result.fold(
                onSuccess = { folderId ->
                    resetChanges()
                    triggerSync()
                    CreateFolderState.Success(folderId)
                },
                onFailure = { throwable ->
                    CreateFolderState.Error(throwable.message ?: "Lỗi")
                }
            )
        }
    }

    private fun triggerSync() {
        viewModelScope.launch {
            try {
                syncAllDataUseCase.sync()
            } catch (e: Exception) {
                // Nếu sync fail cũng không ảnh hưởng trải nghiệm người dùng
                // Chỉ log lỗi để debug
                Log.e("Sync", "Failed to sync after creating folder: ${e.message}")
            }
        }
    }
}

sealed class CreateFolderState {
    data object Idle : CreateFolderState()
    data object Loading : CreateFolderState()
    data class Success(val folderId: Int) : CreateFolderState()
    data class Error(val message: String) : CreateFolderState()
}