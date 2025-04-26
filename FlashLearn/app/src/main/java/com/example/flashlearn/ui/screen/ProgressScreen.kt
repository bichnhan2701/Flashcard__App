package com.example.flashlearn.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flashlearn.ui.component.CategoryProgressChart
import com.example.flashlearn.ui.component.LearningTrendChart
import com.example.flashlearn.ui.component.QuizAccuracyChart
import com.example.flashlearn.ui.component.QuizFrequencyChart
import com.example.flashlearn.ui.viewmodel.ProgressViewModel

@Composable
fun ProgressScreen(
    viewModel: ProgressViewModel = hiltViewModel(),
    onCategoryClick: (Int) -> Unit,
    onQuizClick: (Int) -> Unit
) {
    val tabs = listOf("Tổng quan", "Quiz", "Tiến độ")
    var selectedTab by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        viewModel.loadProgress()
        viewModel.loadAllQuizResults()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Text("📈 Tiến độ học", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))

        when (selectedTab) {
            0 -> OverviewTab(viewModel, onCategoryClick)
            1 -> QuizTab(viewModel, onQuizClick)
            2 -> TrendTab(viewModel)
        }
    }
}

@Composable
fun OverviewTab(
    viewModel: ProgressViewModel,
    onCategoryClick: (Int) -> Unit
) {
    val categories by viewModel.categoryProgress.collectAsState()

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text("📘 Đã học vs chưa học theo từng folder", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))

        CategoryProgressChart(categories) // Biểu đồ 1
        Spacer(Modifier.height(16.dp))

        Text("📁 Danh sách folder", fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))

        categories.forEach { progress ->
            Text(
                text = "${progress.categoryName}: ${progress.rememberedCards}/${progress.totalCards} từ đã nhớ",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { onCategoryClick(progress.categoryId) }
            )
        }
    }
}

@Composable
fun QuizTab(
    viewModel: ProgressViewModel,
    onQuizClick: (Int) -> Unit
) {
    val quizStats by viewModel.quizStats.collectAsState()

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text("🧠 Thống kê quiz", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))

        QuizFrequencyChart(quizStats)  // Biểu đồ 2
        Spacer(Modifier.height(16.dp))

        QuizAccuracyChart(quizStats)  // Biểu đồ 3
        Spacer(Modifier.height(16.dp))

        Text("📂 Quiz theo từng folder", fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))

        quizStats.forEach { quiz ->
            Text(
                text = "Category ${quiz.categoryId}: ${quiz.correctAnswers}/${quiz.totalQuestions} câu đúng",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { onQuizClick(quiz.categoryId) }
            )
        }
    }
}

@Composable
fun TrendTab(viewModel: ProgressViewModel) {
    val quizStats by viewModel.quizStats.collectAsState()

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text("📅 Tiến độ học theo thời gian", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))

        LearningTrendChart(quizStats) // Biểu đồ 4
    }
}