package com.example.flashlearn.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flashlearn.ui.viewmodel.QuizHistoryViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun QuizHistoryScreen(
    categoryId: Int,
    viewModel: QuizHistoryViewModel = hiltViewModel()
) {
    val history by viewModel.quizHistory.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadHistory(categoryId)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Lịch sử quiz", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(history) { result ->
                val date = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date(result.timestamp))
                Text("🕒 $date: ${result.correctAnswers}/${result.totalQuestions} đúng")
            }
        }
    }
}