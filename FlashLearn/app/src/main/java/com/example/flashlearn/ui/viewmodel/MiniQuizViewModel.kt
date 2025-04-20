package com.example.flashlearn.ui.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.MiniQuizQuestion
import com.example.flashlearn.domain.model.MiniQuizResult
import com.example.flashlearn.domain.usecase.GenerateMiniQuizQuestionsUseCase
import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase
import com.example.flashlearn.domain.usecase.SaveMiniQuizResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val saveMiniQuizResultUseCase: SaveMiniQuizResultUseCase
) : ViewModel() {

    private var questions: List<MiniQuizQuestion> = emptyList()
    private var currentIndex = 0
    private var currentCategoryId: Int = -1
    private var correctAnswers = 0
    private val wrongFlashcardIds = mutableListOf<Int>()

    private val _uiState = mutableStateOf<MiniQuizUiState>(MiniQuizUiState.Loading)
    val uiState: State<MiniQuizUiState> = _uiState

    fun loadQuestions(categoryId: Int) {
        viewModelScope.launch {
            _uiState.value = MiniQuizUiState.Loading
            currentCategoryId = categoryId
            val flashcards = getFlashcardsByCategoryUseCase(categoryId)
            questions = generateQuizQuestionsUseCase(flashcards)
            currentIndex = 0
            correctAnswers = 0
            wrongFlashcardIds.clear()

            questions.getOrNull(currentIndex)?.let {
                _uiState.value = MiniQuizUiState.Loaded(it, currentIndex, questions.size)
            }
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
                        wrongFlashcardIds = wrongFlashcardIds  // Truyền danh sách flashcard sai
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