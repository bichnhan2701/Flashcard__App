package com.example.flashlearn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgressDetailViewModel @Inject constructor(
    private val getFlashcardsByCategory: GetFlashcardsByCategoryUseCase
) : ViewModel() {

    private val _flashcards = MutableStateFlow<List<Flashcard>>(emptyList())
    val flashcards: StateFlow<List<Flashcard>> = _flashcards

    fun loadFlashcards(categoryId: Int) {
        viewModelScope.launch {
            _flashcards.value = getFlashcardsByCategory(categoryId)
        }
    }
}