package com.example.flashlearn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.DeleteCategoryWithFlashcardsUseCase
import com.example.flashlearn.domain.usecase.GetCategoryWithFlashcardsUseCase
import com.example.flashlearn.domain.usecase.UpdateCategoryWithFlashcardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditFolderDetailViewModel @Inject constructor(
    private val getCategoryWithFlashcardsUseCase: GetCategoryWithFlashcardsUseCase,
    private val updateCategoryWithFlashcardsUseCase: UpdateCategoryWithFlashcardsUseCase,
    private val deleteCategoryWithFlashcardsUseCase: DeleteCategoryWithFlashcardsUseCase
) : ViewModel() {

    val folderDetail = MutableStateFlow<FolderDetailUiState?>(null)

    fun loadFolderDetail(categoryId: Int) {
        viewModelScope.launch {
            val folder = getCategoryWithFlashcardsUseCase(categoryId)
            folderDetail.value = FolderDetailUiState(
                name = folder.name,
                flashcards = folder.flashcards
            )
        }
    }

    fun updateFolder(categoryId: Int, updatedName: String, updatedCards: List<Flashcard>) {
        viewModelScope.launch {
            updateCategoryWithFlashcardsUseCase(
                categoryId,
                updatedName,
                updatedCards
            )
        }
    }

    fun deleteFolder(categoryId: Int) {
        viewModelScope.launch {
            deleteCategoryWithFlashcardsUseCase(categoryId)
        }
    }
}

data class FolderDetailUiState(
    val name: String,
    val flashcards: List<Flashcard>
)
