package com.example.flashlearn.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavController
import com.example.flashlearn.R
import com.example.flashlearn.navigation.Screen

@Composable
fun MiniQuizResultScreen(
    navController: NavController,
    total: Int,
    correct: Int
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent // Tránh theme ghi đè background
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // 🌈 Background từ drawable
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
                    // ✅ Hình ảnh minh họa
                    Image(
                        painter = painterResource(id = R.drawable.result_image),
                        contentDescription = "Result",
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    // Tiêu đề kết quả
                    Text(
                        text = "Great Job!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    // Hiển thị tổng kết
                    Text(
                        text = "You’ve completed the quiz.",
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    // Hiển thị số câu đúng và tổng câu hỏi
                    Text(
                        text = "You answered $correct out of $total correctly.",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    // Nút quay lại trang chủ hoặc làm lại quiz
                    Button(
                        onClick = {
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Home.route) { inclusive = false }
                                launchSingleTop = true
                            }
                        },
                        modifier = Modifier.fillMaxWidth(0.6f),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("Back to Home")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    // Nút chơi lại quiz (nếu muốn)
                    Button(
                        onClick = {
                            navController.popBackStack() // Điều hướng trở lại quiz
                        },
                        modifier = Modifier.fillMaxWidth(0.6f),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("Play Again")
                    }
                }
            }
        }
    }
}