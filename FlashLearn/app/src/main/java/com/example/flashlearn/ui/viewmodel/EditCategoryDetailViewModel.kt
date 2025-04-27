package com.example.flashlearn.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.usecase.DeleteCategoryWithFlashcardsUseCase
import com.example.flashlearn.domain.usecase.GetCategoryWithFlashcardsUseCase
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase
import com.example.flashlearn.domain.usecase.UpdateCategoryWithFlashcardsUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditFolderDetailViewModel @Inject constructor(
    private val getCategoryWithFlashcardsUseCase: GetCategoryWithFlashcardsUseCase,
    private val updateCategoryWithFlashcardsUseCase: UpdateCategoryWithFlashcardsUseCase,
    private val deleteCategoryWithFlashcardsUseCase: DeleteCategoryWithFlashcardsUseCase,
    private val syncAllDataUseCase: SyncAllDataUseCase
) : ViewModel() {

    val folderDetail = MutableStateFlow<FolderDetailUiState?>(null)

    fun loadFolderDetail(categoryId: Int) {
        viewModelScope.launch {
            val folder = getCategoryWithFlashcardsUseCase(categoryId)
            folderDetail.value = FolderDetailUiState(
                name = folder.name,
                flashcards = folder.flashcards
            )
        }
    }

    fun updateFolder(categoryId: Int, updatedName: String, updatedCards: List<Flashcard>) {
        viewModelScope.launch {
            updateCategoryWithFlashcardsUseCase(
                categoryId,
                updatedName,
                updatedCards
            )
            updateCategoryCardCount(categoryId, updatedCards.size)
            syncAllData() // ✅ Đồng bộ ngay sau khi update
        }
    }

    fun deleteFolder(categoryId: Int) {
        viewModelScope.launch {
            deleteCategoryWithFlashcardsUseCase(categoryId)
            deleteCategoryOnFirebase(categoryId)
            syncAllData() // ✅ Đồng bộ ngay sau khi delete
        }
    }

    private fun syncAllData() {
        viewModelScope.launch {
            try {
                syncAllDataUseCase.sync()
            } catch (e: Exception) {
                Log.e("Sync", "Failed to sync after editing folder: ${e.message}")
            }
        }
    }

    private fun deleteCategoryOnFirebase(categoryId: Int) {
        val uid = FirebaseAuth.getInstance().currentUser?.uid ?: return
        val database = FirebaseDatabase.getInstance().reference
        database.child("users").child(uid).child("categories").child(categoryId.toString()).removeValue()
        database.child("users").child(uid).child("flashcards").child(categoryId.toString()).removeValue()
    }

    private fun updateCategoryCardCount(categoryId: Int, newCardCount: Int) {
        val uid = FirebaseAuth.getInstance().currentUser?.uid ?: return
        val database = FirebaseDatabase.getInstance().reference
        database.child("users").child(uid).child("categories").child(categoryId.toString()).child("cardCount").setValue(newCardCount)
    }
}

data class FolderDetailUiState(
    val name: String,
    val flashcards: List<Flashcard>
)