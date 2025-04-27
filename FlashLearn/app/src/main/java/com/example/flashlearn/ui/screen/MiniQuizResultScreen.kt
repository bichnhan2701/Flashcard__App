package com.example.flashlearn.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.flashlearn.R
import com.example.flashlearn.navigation.Screen
import com.example.flashlearn.ui.component.ActionButton

@Composable
fun MiniQuizResultScreen(
    navController: NavController,
    total: Int,
    correct: Int
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            // Nội dung chính
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.welldone),
                        contentDescription = "Result",
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    // Tiêu đề kết quả
                    Text(
                        text = "You’ve completed the quiz!",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    // Hiển thị số câu đúng và tổng câu hỏi
                    Text(
                        text = "You answered $correct out of $total correctly.",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    ActionButton(
                        text = "Back to Home",
                        icon = null,
                        onClick = {
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Home.route) { inclusive = false }
                                launchSingleTop = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .zIndex(1f),
                        iconSize = 60.dp,
                        contentColor = Color(0xFF3F788C)
                    )
                }
            }
        }
    }
}