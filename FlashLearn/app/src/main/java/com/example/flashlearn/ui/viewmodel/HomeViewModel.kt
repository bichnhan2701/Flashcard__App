package com.example.flashlearn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Category
import com.example.flashlearn.domain.usecase.GetAllCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) : ViewModel() {

    val categories: StateFlow<List<Category>> =
        getAllCategoriesUseCase()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
