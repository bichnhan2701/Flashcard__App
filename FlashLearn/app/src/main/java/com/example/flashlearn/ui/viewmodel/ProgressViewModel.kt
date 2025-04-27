package com.example.flashlearn.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.CategoryProgress
import com.example.flashlearn.domain.model.MiniQuizResult
import com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase
import com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase
import com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase
import com.example.flashlearn.ui.network.NetworkObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgressViewModel @Inject constructor(
    private val getAllQuizResults: GetAllQuizResultsUseCase,
    private val getQuizResultsBetween: GetQuizResultsBetweenUseCase,
    private val getAllCategoriesProgress: GetAllCategoriesProgressUseCase,
    private val syncAllDataUseCase: SyncAllDataUseCase,
    private val networkObserver: NetworkObserver
) : ViewModel() {

    private val _categoryProgress = MutableStateFlow<List<CategoryProgress>>(emptyList())
    val categoryProgress: StateFlow<List<CategoryProgress>> = _categoryProgress

    private val _quizStats = MutableStateFlow<List<MiniQuizResult>>(emptyList())
    val quizStats: StateFlow<List<MiniQuizResult>> = _quizStats

    private var isNetworkAvailable: Boolean = false // ✅ Cache mạng hiện tại

    init {
        // ✅ Observe mạng
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
                        Log.d("Sync", "Data synced successfully (from network observer in ProgressViewModel)")
                        reloadAllData()
                    } catch (e: Exception) {
                        Log.e("Sync", "Failed to sync: ${e.message}")
                    }
                }
            }
        }
    }

    fun loadProgress() {
        viewModelScope.launch {
            if (isNetworkAvailable) {
                try {
                    syncAllDataUseCase.sync()
                    Log.d("Sync", "Data synced successfully (from loadProgress)")
                } catch (e: Exception) {
                    Log.e("Sync", "Failed to sync: ${e.message}")
                }
            }

            _categoryProgress.value = getAllCategoriesProgress()
        }
    }

    fun loadAllQuizResults() {
        viewModelScope.launch {
            if (isNetworkAvailable) {
                try {
                    syncAllDataUseCase.sync()
                    Log.d("Sync", "Data synced successfully (from loadAllQuizResults)")
                } catch (e: Exception) {
                    Log.e("Sync", "Failed to sync: ${e.message}")
                }
            }

            _quizStats.value = getAllQuizResults()
        }
    }

    fun loadQuizResultsBetween(start: Long, end: Long) {
        viewModelScope.launch {
            if (isNetworkAvailable) {
                try {
                    syncAllDataUseCase.sync()
                    Log.d("Sync", "Data synced successfully (from loadQuizResultsBetween)")
                } catch (e: Exception) {
                    Log.e("Sync", "Failed to sync: ${e.message}")
                }
            }

            _quizStats.value = getQuizResultsBetween(start, end)
        }
    }

    private fun reloadAllData() {
        // ✅ Khi mạng có lại và sync thành công -> reload lại UI
        viewModelScope.launch {
            _categoryProgress.value = getAllCategoriesProgress()
            _quizStats.value = getAllQuizResults()
        }
    }
}
