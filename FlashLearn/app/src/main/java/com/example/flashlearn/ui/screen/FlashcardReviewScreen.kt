package com.example.flashlearn.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.flashlearn.navigation.Screen
import com.example.flashlearn.ui.component.ReviewCard
import com.example.flashlearn.ui.viewmodel.FlashcardReviewViewModel

@Composable
fun FlashcardReviewScreen(
    navController: NavController,
    categoryId: Int,
    viewModel: FlashcardReviewViewModel = hiltViewModel()
) {
    val flashcard = viewModel.currentFlashcard
//    val progress = viewModel.reviewProgress
//    val remembered = viewModel.rememberedCount

    LaunchedEffect(categoryId) {
        viewModel.loadFlashcards(categoryId)
    }

    if (flashcard != null) {
        ReviewCard(
            viewModel = viewModel,
            onBack = { navController.popBackStack() }
        )
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No flashcards.")
        }
    }
}
