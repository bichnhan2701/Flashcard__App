package com.example.flashlearn.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flashlearn.ui.viewmodel.ProgressDetailViewModel

@Composable
fun ProgressDetailScreen(
    categoryId: Int,
    viewModel: ProgressDetailViewModel = hiltViewModel()
) {
    val flashcards by viewModel.flashcards.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadFlashcards(categoryId)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Chi tiết tiến độ", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(flashcards) { flashcard ->
                val status = if (flashcard.isRemembered) "✅ Nhớ" else "❌ Chưa nhớ"
                Text("• ${flashcard.term}: $status")
            }
        }
    }
}