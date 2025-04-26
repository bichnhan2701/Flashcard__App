package com.example.flashlearn.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flashlearn.R
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clipToBounds()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        when (val state = uiState) {
            is MiniQuizUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color(0xFF0F81DA))
                }
            }

            is MiniQuizUiState.Loaded -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = categoryName,
                        style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    LinearProgressIndicator(
                        progress = { (state.questionIndex + 1).toFloat() / state.totalQuestions },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        color = Color(0xFF0F81DA)
                    )

                    Text(
                        text = "Question ${state.questionIndex + 1} of ${state.totalQuestions}",
                        style = MaterialTheme.typography.titleMedium.copy(color = Color.White),
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Box(
                            modifier = Modifier.padding(24.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = state.question.definition,
                                style = MaterialTheme.typography.headlineMedium,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))

                    state.question.options.forEachIndexed { index, option ->
                        val isSelected = index == state.selectedIndex
                        val isCorrect = when {
                            isSelected && state.isCorrect == true -> true
                            isSelected && state.isCorrect == false -> false
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

                    if (state.selectedIndex != null) {
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = if (state.isCorrect == true) "\u2714 Correct!" else "\u274C Incorrect!",
                            color = if (state.isCorrect == true) Color(0xFF4CAF50) else Color(0xFFF44336),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { viewModel.goToNext() },
                        enabled = state.selectedIndex != null,
                        modifier = Modifier
                            .align(Alignment.End)
                            .fillMaxWidth(0.4f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0F81DA)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (state.questionIndex == state.totalQuestions - 1) "Finish" else "Next",
                            color = Color.White
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
}