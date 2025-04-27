package com.example.flashlearn.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.MiniQuizResult
import com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase
import com.example.flashlearn.ui.network.NetworkObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizHistoryViewModel @Inject constructor(
    private val getQuizHistory: GetQuizHistoryByCategoryUseCase,
    private val syncAllDataUseCase: SyncAllDataUseCase,
    private val networkObserver: NetworkObserver
) : ViewModel() {

    private val _quizHistory = MutableStateFlow<List<MiniQuizResult>>(emptyList())
    val quizHistory: StateFlow<List<MiniQuizResult>> = _quizHistory

    private var isNetworkAvailable: Boolean = false
    private var lastLoadedCategoryId: Int? = null // ✅ Lưu lại categoryId để reload khi sync


    init {
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
                        Log.d("Sync", "Data synced successfully (from QuizHistoryViewModel)")
                        lastLoadedCategoryId?.let { reloadHistory(it) }
                    } catch (e: Exception) {
                        Log.e("Sync", "Failed to sync: ${e.message}")
                    }
                }
            }
        }
    }

    fun loadHistory(categoryId: Int) {
        viewModelScope.launch {
            if (isNetworkAvailable) {
                try {
                    syncAllDataUseCase.sync()
                    Log.d("Sync", "Data synced successfully (from loadHistory)")
                } catch (e: Exception) {
                    Log.e("Sync", "Failed to sync: ${e.message}")
                }
            }

            _quizHistory.value = getQuizHistory(categoryId)
            lastLoadedCategoryId = categoryId
        }
    }

    private fun reloadHistory(categoryId: Int) {
        viewModelScope.launch {
            _quizHistory.value = getQuizHistory(categoryId)
        }
    }
}