package com.example.flashlearn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.CategoryProgress
import com.example.flashlearn.domain.model.MiniQuizResult
import com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase
import com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase
import com.example.flashlearn.domain.usecase.GetLatestQuizResultByCategoryUseCase
import com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgressViewModel @Inject constructor(
    private val getAllQuizResults: GetAllQuizResultsUseCase,
    private val getQuizResultsBetween: GetQuizResultsBetweenUseCase,
    private val getAllCategoriesProgress: GetAllCategoriesProgressUseCase
) : ViewModel() {

    private val _categoryProgress = MutableStateFlow<List<CategoryProgress>>(emptyList())
    val categoryProgress: StateFlow<List<CategoryProgress>> = _categoryProgress

    private val _quizStats = MutableStateFlow<List<MiniQuizResult>>(emptyList())
    val quizStats: StateFlow<List<MiniQuizResult>> = _quizStats

    fun loadProgress() {
        viewModelScope.launch {
            _categoryProgress.value = getAllCategoriesProgress()
        }
    }

    fun loadAllQuizResults() {
        viewModelScope.launch {
            _quizStats.value = getAllQuizResults()
        }
    }

    fun loadQuizResultsBetween(start: Long, end: Long) {
        viewModelScope.launch {
            _quizStats.value = getQuizResultsBetween(start, end)
        }
    }
}
