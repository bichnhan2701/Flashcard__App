package com.example.flashlearn.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase
import com.example.flashlearn.ui.network.NetworkObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgressDetailViewModel @Inject constructor(
    private val getFlashcardsByCategory: GetFlashcardsByCategoryUseCase,
    private val syncAllDataUseCase: SyncAllDataUseCase,
    private val networkObserver: NetworkObserver
) : ViewModel() {

    private val _flashcards = MutableStateFlow<List<Flashcard>>(emptyList())
    val flashcards: StateFlow<List<Flashcard>> = _flashcards

    private var isNetworkAvailable: Boolean = false // ✅ Cache trạng thái mạng

    init {
        // ✅ Quan sát thay đổi mạng
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
                        Log.d("Sync", "Data synced successfully (from network observer in ProgressDetail)")
                    } catch (e: Exception) {
                        Log.e("Sync", "Failed to sync: ${e.message}")
                    }
                }
            }
        }
    }

    fun loadFlashcards(categoryId: Int) {
        viewModelScope.launch {
            if (isNetworkAvailable) {
                try {
                    syncAllDataUseCase.sync()
                    Log.d("Sync", "Data synced successfully (from loadFlashcards in ProgressDetail)")
                } catch (e: Exception) {
                    Log.e("Sync", "Failed to sync: ${e.message}")
                }
            }

            _flashcards.value = getFlashcardsByCategory(categoryId)
        }
    }
}