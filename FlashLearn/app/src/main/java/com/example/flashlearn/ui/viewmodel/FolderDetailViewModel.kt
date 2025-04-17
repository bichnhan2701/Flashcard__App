package com.example.flashlearn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.FlashcardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FolderDetailViewModel @Inject constructor(
    private val flashcardUseCases: FlashcardUseCases
) : ViewModel() {
    private val _flashcards = MutableStateFlow<List<Flashcard>>(emptyList())
    val flashcards: StateFlow<List<Flashcard>> = _flashcards

    private val _folderName = MutableStateFlow<String>("")
    val folderName: StateFlow<String> = _folderName

    fun load(categoryId: Int, folderName: String) {
        viewModelScope.launch {
            _flashcards.value = flashcardUseCases.getByCategory(categoryId)
            _folderName.value = folderName
        }
    }

    fun toggleFavorite(card: Flashcard) {
        viewModelScope.launch {
            flashcardUseCases.update(card.copy(isFavorite = !card.isFavorite))
            load(card.categoryId, _folderName.value)
        }
    }

//    fun deleteFlashcard(card: Flashcard) {
//        viewModelScope.launch {
//            flashcardUseCases.delete(card)
//            load(card.categoryId, _folderName.value)
//        }
//    }
}
