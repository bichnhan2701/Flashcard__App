package com.example.flashlearn.data.remote

import android.util.Log
import com.example.flashlearn.data.local.mapper.toFirebaseModel
import com.example.flashlearn.domain.model.Category
import com.example.flashlearn.domain.model.FirebaseDataBundle
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.domain.model.MiniQuizResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseRemoteDataSourceImpl @Inject constructor(
    private val database: DatabaseReference, // Tham chiếu Firebase Realtime Database
    private val auth: FirebaseAuth
) : FirebaseRemoteDataSource {

    private fun getUserId(): String {
        return auth.currentUser?.uid ?: throw IllegalStateException("User not logged in")
    }

    override suspend fun uploadCategories(categories: List<Category>) {
        val userId = getUserId()
        val categoryRef = database.child("users").child(userId).child("categories")

        categories.forEach { category ->
            categoryRef.child(category.id.toString()).setValue(category.toFirebaseModel())
        }
    }

    override suspend fun uploadFlashcards(flashcards: List<Flashcard>) {
        val userId = getUserId()
        val flashcardRef = database.child("users").child(userId).child("flashcards")

        flashcards.forEach { flashcard ->
            flashcardRef.child(flashcard.id.toString()).setValue(flashcard.toFirebaseModel())
        }
    }

    override suspend fun uploadMiniQuizResults(results: List<MiniQuizResult>) {
        val userId = getUserId()
        val resultRef = database.child("users").child(userId).child("quizResults")

        results.forEach { result ->
            resultRef.child(result.id.toString()).setValue(result.toFirebaseModel())
        }
    }

    override suspend fun getAllData(): FirebaseDataBundle = withContext(Dispatchers.IO) {
        val userId = getUserId()
        try {
            Log.d("FirebaseRemoteDataSource", "🚀 Fetching all data for userId: $userId")

            val categoriesSnapshot = database.child("users").child(userId).child("categories").get().await()
            val flashcardsSnapshot = database.child("users").child(userId).child("flashcards").get().await()
            val quizResultsSnapshot = database.child("users").child(userId).child("quizResults").get().await()

            Log.d("FirebaseRemoteDataSource", "✅ Fetch done: categories=${categoriesSnapshot.childrenCount}, flashcards=${flashcardsSnapshot.childrenCount}, quizResults=${quizResultsSnapshot.childrenCount}")

            val categories = categoriesSnapshot.children.mapNotNull { it.getValue(Category::class.java) }
            val flashcards = flashcardsSnapshot.children.mapNotNull { it.getValue(Flashcard::class.java) }
            val quizResults = quizResultsSnapshot.children.mapNotNull { it.getValue(MiniQuizResult::class.java) }

            FirebaseDataBundle(
                categories = categories,
                flashcards = flashcards,
                miniQuizResults = quizResults
            )
        } catch (e: Exception) {
            Log.e("FirebaseRemoteDataSource", "❌ Error fetching data: ${e.message}")
            throw e
        }
    }


    // 🔥 Thêm mới: Xoá toàn bộ data người dùng trên Firebase
    override suspend fun deleteAllData() {
        val userId = getUserId()

        database.child("users").child(userId).child("categories").removeValue().await()
        database.child("users").child(userId).child("flashcards").removeValue().await()
        database.child("users").child(userId).child("quizResults").removeValue().await()
    }

    override suspend fun clearCurrentUserData() {
        val userId = getUserId()
        database.child("users").child(userId).removeValue().await()
    }
}