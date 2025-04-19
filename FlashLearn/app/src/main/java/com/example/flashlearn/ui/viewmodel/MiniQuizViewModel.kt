package com.example.flashlearn.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.flashlearn.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MiniQuizViewModel : ViewModel() {
    private val _questions = MutableStateFlow(
        listOf(
            Question("abide by", listOf("bến học", "tuân thủ", "đạp xe", "đi học"), 1),
            Question("bring up", listOf("nuôi dưỡng", "hạ xuống", "mang đi", "nói to"), 0),
            Question("call off", listOf("gọi điện", "hủy bỏ", "gọi lại", "bắt đầu"), 1)
            // ➕ Add more questions as needed
        )
    )
    val questions: StateFlow<List<Question>> = _questions

    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex

    val currentQuestion = mutableStateOf(_questions.value[_currentIndex.value])
    val selectedAnswerIndex = mutableStateOf<Int?>(null)
    val isAnswerCorrect = mutableStateOf<Boolean?>(null)

    fun selectAnswer(index: Int) {
        selectedAnswerIndex.value = index
        isAnswerCorrect.value = index == currentQuestion.value.correctAnswerIndex
    }

    fun goToNextQuestion() {
        if (_currentIndex.value < _questions.value.size - 1) {
            _currentIndex.value++
            updateCurrentQuestion()
        }
    }

    private fun updateCurrentQuestion() {
        currentQuestion.value = _questions.value[_currentIndex.value]
        selectedAnswerIndex.value = null
        isAnswerCorrect.value = null
    }

    fun getQuestionProgress(): String =
        "Question ${_currentIndex.value + 1} / ${_questions.value.size}"

    fun getQuestions(): List<Question> = _questions.value

    fun getCurrentIndex(): Int = _currentIndex.value

    // ✅ Hàm dùng cho nút "Next" trong QuizScreen
    fun goToNext(navController: NavController) {
        if (_currentIndex.value < _questions.value.size - 1) {
            goToNextQuestion()
        } else {
            navController.navigate(Screen.MiniQuizResult.route)
        }
    }
}

data class Question(
    val term: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)