package com.example.flashlearn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.FlashcardUseCases
import com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val flashcardUseCases: FlashcardUseCases,
    private val getCategoryByIdUseCase: GetCategoryByIdUseCase
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
            load(card.categoryId)
        }
    }

//    fun deleteFlashcard(card: Flashcard) {
//        viewModelScope.launch {
//            flashcardUseCases.delete(card)
//            load(card.categoryId, _folderName.value)
//        }
//    }
}
