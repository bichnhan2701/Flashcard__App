package com.example.flashlearn.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.flashlearn.R
import com.example.flashlearn.ui.viewmodel.MiniQuizViewModel

@Composable
fun MiniQuizScreen(navController: NavController, viewModel: MiniQuizViewModel = viewModel() ) {
    val question = viewModel.currentQuestion.value
    val selected = viewModel.selectedAnswerIndex.value
    val isCorrect = viewModel.isAnswerCorrect.value
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clipToBounds()
    ) {
        // 🌈 Gradient background từ drawable
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🔙 Back button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            // 📊 Progress indicator
            LinearProgressIndicator(
                progress = { (viewModel.getCurrentIndex() + 1).toFloat() / viewModel.getQuestions().size },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = Color(0xFF0F81DA),
            )

            Text(
                text = viewModel.getQuestionProgress(),
                modifier = Modifier.padding(vertical = 8.dp),
                style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
            )

            if (question != null) {
                // 📖 Câu hỏi
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
                            text = question.term,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 🔘 Các lựa chọn
                question.options.forEachIndexed { index, option ->
                    OptionButton(
                        optionLabel = ('A' + index).toString(),
                        text = option,
                        onClick = { viewModel.selectAnswer(index) },
                        isSelected = selected == index,
                        isCorrect = if (selected == index) isCorrect else null
                    )
                }

                // ✅❌ Phản hồi đúng/sai
                if (isCorrect != null) {
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = if (isCorrect) "\u2714 Correct!" else "\u274C Incorrect!",
                        color = if (isCorrect) Color(0xFF4CAF50) else Color(0xFFF44336),
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { viewModel.goToNext(navController) },
                        modifier = Modifier.fillMaxWidth(0.4f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0F81DA)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Next")
                    }
                }
            } else {
                Text("Questions are loading...", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun OptionButton(
    optionLabel: String,
    text: String,
    onClick: () -> Unit,
    isSelected: Boolean = false,
    isCorrect: Boolean? = null
) {
    val backgroundColor = when (isCorrect) {
        true -> Color(0xFFB9FBC0)
        false -> Color(0xFFFFC9C9)
        null -> Color.White
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = optionLabel,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3F51B5),
                modifier = Modifier.width(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text)
        }
    }
}