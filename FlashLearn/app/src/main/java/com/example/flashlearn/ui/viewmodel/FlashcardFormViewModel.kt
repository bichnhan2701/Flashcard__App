package com.example.flashlearn.ui.viewmodel

import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.utils.defaultFlashcards
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FlashcardFormViewModel @Inject constructor() : UnsavedChangesViewModel() {
    private val now = System.currentTimeMillis()

    private val _flashcards = MutableStateFlow<List<Flashcard>>(emptyList())
    val flashcards: StateFlow<List<Flashcard>> = _flashcards

    private val _errors = MutableStateFlow<Map<Int, Pair<Boolean, Boolean>>>(emptyMap())
    val errors: StateFlow<Map<Int, Pair<Boolean, Boolean>>> = _errors

    fun initFlashcards(initial: List<Flashcard> = defaultFlashcards()) {
        _flashcards.value = initial
    }

    fun updateCard(index: Int, updated: Flashcard) {
        _flashcards.value = _flashcards.value.toMutableList().apply { set(index, updated) }
        setUnsavedChanges(true)
    }

    fun addCard() {
        _flashcards.value += Flashcard(
            term = "",
            definition = "",
            categoryId = 0,
            isFavorite = false,
            pronunciation = null,
            isRemembered = false,
            createdAt = now,
            updatedAt = now
        )
        setUnsavedChanges(true)
    }

    fun removeCard(index: Int): Boolean {
        if (_flashcards.value.size <= 2) return false
        _flashcards.value = _flashcards.value.toMutableList().apply { removeAt(index) }
        setUnsavedChanges(true)
        return true
    }

    fun validate(): Boolean {
        val errMap = _flashcards.value.mapIndexed { index, card ->
            val termErr = card.term.isBlank()
            val defErr = card.definition.isBlank()
            index to (termErr to defErr)
        }.filter { it.second.first || it.second.second }.toMap()

        _errors.value = errMap
        return errMap.isEmpty()
    }

    fun getFlashcards(): List<Flashcard> = _flashcards.value
}
