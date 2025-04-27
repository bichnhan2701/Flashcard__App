package com.example.flashlearn.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.flashlearn.ui.component.BottomNavigationBar
import com.example.flashlearn.ui.component.CategoryProgressChart
import com.example.flashlearn.ui.component.LearningTrendChart
import com.example.flashlearn.ui.component.QuizAccuracyChart
import com.example.flashlearn.ui.component.QuizFrequencyChart
import com.example.flashlearn.ui.viewmodel.ProgressViewModel

@Composable
fun ProgressScreen(
    viewModel: ProgressViewModel = hiltViewModel(),
    navController: NavController
) {
    val tabs = listOf("Overview", "Mini Quiz", "Progress")
    var selectedTab by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        viewModel.loadProgress()
        viewModel.loadAllQuizResults()
    }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }, // 🔥 Thêm BottomNavBar ở đây
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE0F7FA))
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                "Learning Progress",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 16.dp)
            )

            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color(0xFFE0F7FA), // xanh nhạt
                contentColor = Color(0xFF00796B),   // xanh đậm
                indicator = { tabPositions ->
                    SecondaryIndicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                        color = Color(0xFF00796B)
                    )
                }
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = {
                            Text(
                                title,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (selectedTab == index) Color(0xFF00796B) else Color.Gray
                            )
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            when (selectedTab) {
                0 -> OverviewTab(viewModel)
                1 -> QuizTab(viewModel)
                2 -> TrendTab(viewModel)
            }
        }
    }
}

// --- OverviewTab ---
@Composable
fun OverviewTab(
    viewModel: ProgressViewModel
) {
    val categories by viewModel.categoryProgress.collectAsState()

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(8.dp))

        if (categories.isEmpty()) {
            EmptyChartView(message = "No category yet, let's add a new one!")
        } else {
            CategoryProgressChart(categories)
            SectionTitle("Review Tracking Chart")
        }
    }
}

// --- QuizTab ---
@Composable
fun QuizTab(
    viewModel: ProgressViewModel
) {
    val quizStats by viewModel.quizStats.collectAsState()

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        if (quizStats.isEmpty()) {
            EmptyChartView(message = "There is no quiz data yet!")
        } else {
            Text(
                "Quiz Statistics",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF39544F)
            )

            QuizFrequencyChart(quizStats)
            SectionTitle("Quiz Frequency Chart", topPadding = 8.dp)

            QuizAccuracyChart(quizStats)
            SectionTitle("Quiz Accuracy Chart", topPadding = 8.dp)
        }
    }
}

// --- TrendTab ---
@Composable
fun TrendTab(viewModel: ProgressViewModel) {
    val quizStats by viewModel.quizStats.collectAsState()

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(8.dp))
        if (quizStats.isEmpty()) {
            EmptyChartView(message = "No data available to show learning progress!")
        } else {
            LearningTrendChart(quizStats)
            SectionTitle("Tracking Learning Progress over time Chart")
        }
    }
}

// --- Component nhỏ tái sử dụng ---
@Composable
fun EmptyChartView(message: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SectionTitle(text: String, topPadding: Dp = 8.dp) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = topPadding),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color(0xFF39544F)
        )
    }
}