package com.example.flashlearn.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.CreateCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFolderViewModel @Inject constructor(
    private val createCategoryUseCase: CreateCategoryUseCase
) : UnsavedChangesViewModel() {

    private val _state = MutableStateFlow<CreateFolderState>(CreateFolderState.Idle)
    val state: StateFlow<CreateFolderState> = _state

    fun createFolder(name: String, flashcards: List<Flashcard>) {
        viewModelScope.launch {
            _state.value = CreateFolderState.Loading
            val result = createCategoryUseCase(name, flashcards)
            _state.value = result.fold(
                onSuccess = {
                    resetChanges()
                    CreateFolderState.Success(it)
                },
                onFailure = { CreateFolderState.Error(it.message ?: "Lỗi") }
            )
        }
    }
}

sealed class CreateFolderState {
    data object Idle : CreateFolderState()
    data object Loading : CreateFolderState()
    data class Success(val folderId: Int) : CreateFolderState()
    data class Error(val message: String) : CreateFolderState()
}


