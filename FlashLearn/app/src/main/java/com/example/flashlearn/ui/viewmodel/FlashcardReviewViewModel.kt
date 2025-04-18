package com.example.flashlearn.ui.viewmodel

import android.app.Application
import android.speech.tts.TextToSpeech
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.FlashcardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FlashcardReviewViewModel @Inject constructor(
    application: Application,
    private val flashcardUseCases: FlashcardUseCases
) : AndroidViewModel(application) {

    private val _flashcards = mutableStateListOf<Flashcard>()
    val flashcards: List<Flashcard> get() = _flashcards

    private val _currentIndex = mutableIntStateOf(0)
    val currentIndex: State<Int> get() = _currentIndex

    val currentFlashcard: Flashcard?
        get() = _flashcards.getOrNull(_currentIndex.intValue)

    val rememberedCount: Int
        get() = _flashcards.count { it.isRemembered }

    val reviewProgress: Float
        get() = if (_flashcards.isNotEmpty()) rememberedCount / _flashcards.size.toFloat() else 0f

    // Lật thẻ
    private val _isFlipped = mutableStateOf(false)
    val isFlipped: State<Boolean> get() = _isFlipped

    fun flipCard() {
        _isFlipped.value = !_isFlipped.value
    }
    fun resetFlip() {
        _isFlipped.value = false
    }
    fun setIsFront(isFront: Boolean) {
        _isFlipped.value = !isFront
    }

    fun nextFlashcard() {
        if (_currentIndex.intValue < _flashcards.lastIndex) {
            _currentIndex.value += 1
            resetFlip()
        }
    }

    fun previousFlashcard() {
        if (_currentIndex.intValue > 0) {
            _currentIndex.value -= 1
            resetFlip()
        }
    }
    // Load dữ liệu
    fun loadFlashcards(categoryId: Int) {
        viewModelScope.launch {
            val cards = flashcardUseCases.getByCategory(categoryId)
            _flashcards.clear()
            _flashcards.addAll(cards)
            _currentIndex.intValue = 0
            resetFlip()
        }
    }
    // Đánh dấu đã nhớ
    fun rememberCurrentFlashcard() {
        currentFlashcard?.let { card ->
            if (!card.isRemembered) {
                val updated = card.copy(isRemembered = true)
                _flashcards[_currentIndex.intValue] = updated

                viewModelScope.launch {
                    flashcardUseCases.update(updated)
                }
            }
        }
    }

    // Text to Speech
    private var tts: TextToSpeech? = null

    init {
        tts = TextToSpeech(application.applicationContext) {
            if (it == TextToSpeech.SUCCESS) {
                tts?.language = Locale.US
            }
        }
    }

    fun speakTerm() {
        currentFlashcard?.term?.let {
            tts?.speak(it, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    override fun onCleared() {
        tts?.stop()
        tts?.shutdown()
        super.onCleared()
    }
}
