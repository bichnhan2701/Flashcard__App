package com.example.flashlearn.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.FlashcardUseCases
import com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val flashcardUseCases: FlashcardUseCases,
    private val getCategoryByIdUseCase: GetCategoryByIdUseCase,
    private val syncAllDataUseCase: SyncAllDataUseCase
) : ViewModel() {
    private val _flashcards = MutableStateFlow<List<Flashcard>>(emptyList())
    val flashcards: StateFlow<List<Flashcard>> = _flashcards

    private val _categoryName = MutableStateFlow("")
    val categoryName: StateFlow<String> = _categoryName

    fun load(categoryId: Int) {
        viewModelScope.launch {
            _flashcards.value = flashcardUseCases.getByCategory(categoryId)
            _categoryName.value = getCategoryByIdUseCase(categoryId)?.name ?: "Không rõ"
        }
    }

    fun toggleFavorite(card: Flashcard) {
        viewModelScope.launch {
            flashcardUseCases.update(card.copy(isFavorite = !card.isFavorite))
            triggerSync()
            load(card.categoryId)
        }
    }

    private fun triggerSync() {
        viewModelScope.launch {
            try {
                syncAllDataUseCase.sync()
            } catch (e: Exception) {
                // Sync fail chỉ log lỗi, không ảnh hưởng trải nghiệm người dùng
                Log.e("Sync", "Failed to sync after toggling favorite: ${e.message}")
            }
        }
    }
}