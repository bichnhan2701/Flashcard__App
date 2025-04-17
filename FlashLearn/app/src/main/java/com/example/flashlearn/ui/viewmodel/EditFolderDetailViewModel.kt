package com.example.flashlearn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.DeleteFolderWithFlashcardsUseCase
import com.example.flashlearn.domain.usecase.GetFolderWithFlashcardsUseCase
import com.example.flashlearn.domain.usecase.UpdateFolderWithFlashcardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditFolderDetailViewModel @Inject constructor(
    private val getFolderWithFlashcardsUseCase: GetFolderWithFlashcardsUseCase,
    private val updateFolderWithFlashcardsUseCase: UpdateFolderWithFlashcardsUseCase,
    private val deleteFolderWithFlashcardsUseCase: DeleteFolderWithFlashcardsUseCase
) : ViewModel() {

    val folderDetail = MutableStateFlow<FolderDetailUiState?>(null)

    fun loadFolderDetail(categoryId: Int) {
        viewModelScope.launch {
            val folder = getFolderWithFlashcardsUseCase(categoryId)
            folderDetail.value = FolderDetailUiState(
                name = folder.name,
                flashcards = folder.flashcards
            )
        }
    }

    fun updateFolder(categoryId: Int, updatedName: String, updatedCards: List<Flashcard>) {
        viewModelScope.launch {
            updateFolderWithFlashcardsUseCase(
                categoryId,
                updatedName,
                updatedCards
            )
        }
    }

    fun deleteFolder(categoryId: Int) {
        viewModelScope.launch {
            deleteFolderWithFlashcardsUseCase(categoryId)
        }
    }
}

data class FolderDetailUiState(
    val name: String,
    val flashcards: List<Flashcard>
)
