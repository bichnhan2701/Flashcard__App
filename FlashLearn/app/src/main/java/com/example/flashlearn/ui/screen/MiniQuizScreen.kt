package com.example.flashlearn.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flashlearn.ui.component.OptionButton
import com.example.flashlearn.ui.viewmodel.MiniQuizUiState
import com.example.flashlearn.ui.viewmodel.MiniQuizViewModel

@Composable
fun MiniQuizScreen(
    categoryId: Int,
    viewModel: MiniQuizViewModel = hiltViewModel(),
    onFinish: (total: Int, correct: Int) -> Unit
) {
    val uiState by viewModel.uiState
    val optionLabels = listOf("A", "B", "C", "D")
    val categoryName by viewModel.categoryName.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadQuestions(categoryId)
    }

    when (val state = uiState) {
        is MiniQuizUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is MiniQuizUiState.Loaded -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    categoryName,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Question ${state.questionIndex + 1} of ${state.totalQuestions}",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = state.question.definition,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(24.dp))

                state.question.options.forEachIndexed { index, option ->
                    val isSelected = index == state.selectedIndex
                    val isCorrect = when {
                        // Nếu đã chọn và đúng
                        isSelected && state.isCorrect == true -> true
                        // Nếu đã chọn và sai
                        isSelected && state.isCorrect == false -> false
                        // Nếu KHÔNG chọn nhưng là đáp án đúng → highlight để người dùng biết
                        !isSelected && state.selectedIndex != null && option == state.question.correctAnswer -> true
                        else -> null
                    }

                    OptionButton(
                        optionLabel = optionLabels.getOrElse(index) { "" },
                        text = option,
                        onClick = { viewModel.selectAnswer(index) },
                        isSelected = isSelected,
                        isCorrect = isCorrect
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { viewModel.goToNext() },
                    enabled = state.selectedIndex != null,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = if (state.questionIndex == state.totalQuestions - 1) "Finish" else "Next"
                    )
                }
            }
        }

        is MiniQuizUiState.Finished -> {
            LaunchedEffect(Unit) {
                onFinish(state.total, state.correct)
            }
        }
    }
}