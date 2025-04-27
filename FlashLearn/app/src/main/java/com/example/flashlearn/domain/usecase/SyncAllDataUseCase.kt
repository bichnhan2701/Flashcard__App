package com.example.flashlearn.domain.usecase

import android.util.Log
import com.example.flashlearn.data.remote.FirebaseRemoteDataSource
import com.example.flashlearn.domain.repository.CategoryRepository
import com.example.flashlearn.domain.repository.FlashcardRepository
import com.example.flashlearn.domain.repository.MiniQuizRepository
import com.example.flashlearn.domain.repository.SharedPreferencesRepository
import javax.inject.Inject

class SyncAllDataUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val flashcardRepository: FlashcardRepository,
    private val miniQuizRepository: MiniQuizRepository,
    private val firebaseRemoteDataSource: FirebaseRemoteDataSource,
    private val sharedPreferencesRepository: SharedPreferencesRepository
) {
    suspend fun sync() {
        val lastSyncedAt = sharedPreferencesRepository.getLastSyncedAt()
        val hasLocalData = categoryRepository.hasAnyCategory()

        if (hasLocalData) {
            uploadNewData(lastSyncedAt)
        }

        downloadAllData()

        sharedPreferencesRepository.setLastSyncedAt(System.currentTimeMillis())
    }

    private suspend fun uploadNewData(lastSyncedAt: Long) {
        val updatedCategories = categoryRepository.getUpdatedCategories(lastSyncedAt)
        val updatedFlashcards = flashcardRepository.getUpdatedFlashcards(lastSyncedAt)
        val updatedMiniQuizResults = miniQuizRepository.getUpdatedMiniQuizResults(lastSyncedAt)

        firebaseRemoteDataSource.uploadCategories(updatedCategories)
        firebaseRemoteDataSource.uploadFlashcards(updatedFlashcards)
        firebaseRemoteDataSource.uploadMiniQuizResults(updatedMiniQuizResults)
    }

    private suspend fun downloadAllData() {
        Log.d("SyncAllDataUseCase", "⚡ START downloadAllData()")

        val allData = firebaseRemoteDataSource.getAllData()

        Log.d("SyncAllDataUseCase", "📥 Downloaded data: ${allData.categories.size} categories, ${allData.flashcards.size} flashcards, ${allData.miniQuizResults.size} quizzes")

        // XÓA sạch LOCAL database
        categoryRepository.deleteAllCategories()
        flashcardRepository.deleteAllFlashcards()
        miniQuizRepository.deleteAllMiniQuizResults()

        Log.d("SyncAllDataUseCase", "🧹 Local database cleared")

        // Save về Room
        allData.categories.forEach {
            Log.d("SyncAllDataUseCase", "Saving category: ${it.name}")
            categoryRepository.createCategory(it)
        }
        allData.flashcards.groupBy { it.categoryId }.forEach { (categoryId, flashcards) ->
            Log.d("SyncAllDataUseCase", "Saving ${flashcards.size} flashcards for categoryId: $categoryId")
            categoryRepository.addFlashcardsToCategory(categoryId, flashcards)
        }
        allData.miniQuizResults.forEach {
            Log.d("SyncAllDataUseCase", "Saving quiz result: ${it.id}")
            miniQuizRepository.saveQuizResult(it)
        }

        Log.d("SyncAllDataUseCase", "✅ Download and save completed")
    }



    fun resetLastSyncedAt() {
        sharedPreferencesRepository.resetLastSyncedAt()
    }

    suspend fun clearLocalDatabase() {
        categoryRepository.deleteAllCategories()
        flashcardRepository.deleteAllFlashcards()
        miniQuizRepository.deleteAllMiniQuizResults()
    }
}