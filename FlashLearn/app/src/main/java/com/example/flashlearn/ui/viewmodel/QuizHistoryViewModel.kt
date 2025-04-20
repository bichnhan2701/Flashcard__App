package com.example.flashlearn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.MiniQuizResult
import com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizHistoryViewModel @Inject constructor(
    private val getQuizHistory: GetQuizHistoryByCategoryUseCase
) : ViewModel() {

    private val _quizHistory = MutableStateFlow<List<MiniQuizResult>>(emptyList())
    val quizHistory: StateFlow<List<MiniQuizResult>> = _quizHistory

    fun loadHistory(categoryId: Int) {
        viewModelScope.launch {
            _quizHistory.value = getQuizHistory(categoryId)
        }
    }
}