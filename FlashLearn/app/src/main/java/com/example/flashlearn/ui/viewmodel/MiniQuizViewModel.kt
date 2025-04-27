package com.example.flashlearn.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.MiniQuizQuestion
import com.example.flashlearn.domain.model.MiniQuizResult
import com.example.flashlearn.domain.usecase.GenerateMiniQuizQuestionsUseCase
import com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase
import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase
import com.example.flashlearn.domain.usecase.SaveMiniQuizResultUseCase
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase
import com.example.flashlearn.ui.network.NetworkObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class MiniQuizUiState {
    data object Loading : MiniQuizUiState()
    data class Loaded(
        val question: MiniQuizQuestion,
        val questionIndex: Int,
        val totalQuestions: Int,
        val selectedIndex: Int? = null,
        val isCorrect: Boolean? = null,
        val correctCount: Int = 0
    ) : MiniQuizUiState()

    data class Finished(val total: Int, val correct: Int) : MiniQuizUiState()
}

@HiltViewModel
class MiniQuizViewModel @Inject constructor(
    private val getFlashcardsByCategoryUseCase: GetFlashcardsByCategoryUseCase,
    private val generateQuizQuestionsUseCase: GenerateMiniQuizQuestionsUseCase,
    private val saveMiniQuizResultUseCase: SaveMiniQuizResultUseCase,
    private val getCategoryByIdUseCase: GetCategoryByIdUseCase,
    private val syncAllDataUseCase: SyncAllDataUseCase,
    private val networkObserver: NetworkObserver
) : ViewModel() {
    private val _categoryName = MutableStateFlow("")
    val categoryName: StateFlow<String> = _categoryName

    private var questions: List<MiniQuizQuestion> = emptyList()
    private var currentIndex = 0
    private var currentCategoryId: Int = -1
    private var correctAnswers = 0
    private val wrongFlashcardIds = mutableListOf<Int>()

    private val _uiState = mutableStateOf<MiniQuizUiState>(MiniQuizUiState.Loading)
    val uiState: State<MiniQuizUiState> = _uiState

    private var isNetworkAvailable: Boolean = false // ✅ Cache lại status mạng

    init {
        // Quan sát mạng
        viewModelScope.launch {
            networkObserver.observe().collect { status ->
                isNetworkAvailable = when (status) {
                    NetworkObserver.Status.Available -> true
                    NetworkObserver.Status.Losing,
                    NetworkObserver.Status.Lost,
                    NetworkObserver.Status.Unavailable -> false
                }

                if (isNetworkAvailable) {
                    try {
                        syncAllDataUseCase.sync()
                        Log.d("Sync", "Data synced successfully (from network observer)")
                    } catch (e: Exception) {
                        Log.e("Sync", "Failed to sync: ${e.message}")
                    }
                }
            }
        }
    }

    fun loadQuestions(categoryId: Int) {
        viewModelScope.launch {
            _uiState.value = MiniQuizUiState.Loading
            currentCategoryId = categoryId

            if (isNetworkAvailable) {
                try {
                    syncAllDataUseCase.sync()
                    Log.d("Sync", "Data synced successfully (from loadQuestions)")
                } catch (e: Exception) {
                    Log.e("Sync", "Failed to sync: ${e.message}")
                }
            }

            val flashcards = getFlashcardsByCategoryUseCase(categoryId)
            questions = generateQuizQuestionsUseCase(flashcards)
            currentIndex = 0
            correctAnswers = 0
            wrongFlashcardIds.clear()

            questions.getOrNull(currentIndex)?.let {
                _uiState.value = MiniQuizUiState.Loaded(it, currentIndex, questions.size)
            }
            _categoryName.value = getCategoryByIdUseCase(categoryId)?.name ?: "Không rõ"
        }
    }

    fun selectAnswer(index: Int) {
        val currentQuestion = questions.getOrNull(currentIndex) ?: return
        val isCorrect = currentQuestion.options[index] == currentQuestion.correctAnswer
        if (isCorrect) correctAnswers++
        else wrongFlashcardIds.add(currentQuestion.flashcardId)

        _uiState.value = MiniQuizUiState.Loaded(
            question = currentQuestion,
            questionIndex = currentIndex,
            totalQuestions = questions.size,
            selectedIndex = index,
            isCorrect = isCorrect,
            correctCount = correctAnswers
        )
    }

    fun goToNext() {
        if (currentIndex < questions.lastIndex) {
            currentIndex++
            _uiState.value = MiniQuizUiState.Loaded(
                question = questions[currentIndex],
                questionIndex = currentIndex,
                totalQuestions = questions.size,
                correctCount = correctAnswers
            )
        } else {
            // Lưu kết quả
            viewModelScope.launch {
                saveMiniQuizResultUseCase(
                    MiniQuizResult(
                        categoryId = currentCategoryId,
                        totalQuestions = questions.size,
                        correctAnswers = correctAnswers,
                        wrongFlashcardIds = wrongFlashcardIds,  // Truyền danh sách flashcard sai
                        updateAt = System.currentTimeMillis()
                    )
                )
                _uiState.value = MiniQuizUiState.Finished(
                    total = questions.size,
                    correct = correctAnswers
                )
            }
        }
    }
}