package com.example.flashlearn.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Category
import com.example.flashlearn.domain.usecase.GetAllCategoriesUseCase
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase
import com.example.flashlearn.ui.network.NetworkObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val syncAllDataUseCase: SyncAllDataUseCase,
    private val networkObserver: NetworkObserver
) : ViewModel() {

    private val allCategories = getAllCategoriesUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _searchInput = MutableStateFlow("")
    val searchInput: StateFlow<String> = _searchInput

    private val _filteredCategories = MutableStateFlow<List<Category>>(emptyList())
    val filteredCategories: StateFlow<List<Category>> = _filteredCategories

    private val _searchQuery = MutableStateFlow<String?>(null)
    val searchQuery: StateFlow<String?> = _searchQuery

    init {
        // Mặc định hiển thị tất cả
        viewModelScope.launch {
            allCategories.collect {
                _filteredCategories.value = it
            }
        }

        // ✅ Mới: Observe mạng và trigger đồng bộ
        viewModelScope.launch {
            networkObserver.observe().collect { status ->
                if (status == NetworkObserver.Status.Available) {
                    try {
                        syncAllDataUseCase.sync()
                        Log.d("Sync", "Data synced successfully")
                    } catch (e: Exception) {
                        Log.e("Sync", "Failed to sync: ${e.message}")
                    }
                }
            }
        }
    }

    fun onSearchInputChanged(input: String) {
        _searchInput.value = input
    }

    fun onSearchSubmit() {
        val query = _searchInput.value.trim()
        Log.d("Search", "Submit with: $query") // ✅ Thêm dòng này
        _searchQuery.value = if (query.isEmpty()) null else query
        _filteredCategories.value = if (query.isEmpty()) {
            allCategories.value
        } else {
            allCategories.value.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
    }

    fun clearSearch() {
        _searchQuery.value = null
        _searchInput.value = ""
        _filteredCategories.value = allCategories.value
    }
}