package com.example.flashlearn.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashlearn.navigation.Screen

@Composable
fun StartMiniQuizScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE9F3F5),
                        Color(0xFFD9F0F3),
                        Color(0xFFC6E4E8)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(20.dp)
                .height(300.dp),
            shape = MaterialTheme.shapes.medium,
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val text = "FlashLearn"
                val colors = listOf(
                    Color(0xFF90A4AE),
                    Color(0xFFCDE7F0),
                    Color(0xFFF8D7E3),
                    Color(0xFFF8F1C7),
                    Color(0xFFB0BEC5),
                    Color(0xFF1A237E),
                    Color(0xFF1A237E),
                    Color(0xFF1A237E),
                    Color(0xFF1A237E),
                    Color(0xFF1A237E)
                )

                Text(
                    buildAnnotatedString {
                        text.forEachIndexed { index, char ->
                            val colorIndex = index % colors.size
                            withStyle(style = SpanStyle(color = colors[colorIndex])) {
                                append(char)
                            }
                        }
                    },
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "Quiz",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = "Choose a definition that matches the term given.",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                )
                Button(
                    onClick = {
                        navController.navigate(Screen.MiniQuiz.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.5f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3EA2AF),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Start")
                }
            }
        }
    }
}