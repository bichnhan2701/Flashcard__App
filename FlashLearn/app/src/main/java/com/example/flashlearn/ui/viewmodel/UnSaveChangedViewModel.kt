package com.example.flashlearn.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class UnsavedChangesViewModel : ViewModel() {
    private val _hasUnsavedChanges = MutableStateFlow(false)
    val hasUnsavedChanges: StateFlow<Boolean> = _hasUnsavedChanges

    fun setUnsavedChanges(changed: Boolean) {
        _hasUnsavedChanges.value = changed
    }

    fun resetChanges() {
        _hasUnsavedChanges.value = false
    }
}
