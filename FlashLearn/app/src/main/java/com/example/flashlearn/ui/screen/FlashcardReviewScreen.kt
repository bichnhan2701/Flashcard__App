package com.example.flashlearn.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.flashlearn.ui.component.ActionButton
import com.example.flashlearn.ui.component.ReviewCard
import com.example.flashlearn.ui.viewmodel.FlashcardReviewViewModel

@Composable
fun FlashcardReviewScreen(
    navController: NavController,
    categoryId: Int,
    viewModel: FlashcardReviewViewModel = hiltViewModel()
) {
    val flashcard = viewModel.currentFlashcard
    val categoryName by viewModel.categoryName.collectAsState()

    LaunchedEffect(categoryId) {
        viewModel.loadFlashcards(categoryId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE2F0F7))
    ) {
        TopBar(categoryName) { navController.popBackStack() }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            if (flashcard != null) {
                ReviewCard(viewModel = viewModel, modifier = Modifier.align(Alignment.TopCenter))
            } else {
                Text("No flashcards.")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth() .padding(bottom = 100.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            ActionButton(
                text = "Đã nhớ",
                icon = Icons.Default.Check,
                onClick = { viewModel.rememberCurrentFlashcard() },
                containerColor = Color(0xFF4CAF50),
                iconBackgroundColor = Color.Transparent,
                contentColor = Color.White
            )
        }
    }
}

@Composable
private fun TopBar(categoryName: String, onBack: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBack) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = categoryName)
    }
}