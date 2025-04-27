package com.example.flashlearn.data.remote

import com.example.flashlearn.domain.model.Category
import com.example.flashlearn.domain.model.FirebaseDataBundle
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.model.MiniQuizResult

interface FirebaseRemoteDataSource {
    suspend fun uploadCategories(categories: List<Category>)
    suspend fun uploadFlashcards(flashcards: List<Flashcard>)
    suspend fun uploadMiniQuizResults(results: List<MiniQuizResult>)

    suspend fun getAllData(): FirebaseDataBundle
    suspend fun deleteAllData()
    suspend fun clearCurrentUserData()
}