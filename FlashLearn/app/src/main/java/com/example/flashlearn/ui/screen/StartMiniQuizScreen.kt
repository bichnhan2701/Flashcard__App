package com.example.flashlearn.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashlearn.R
import com.example.flashlearn.navigation.Screen

@Composable
fun StartMiniQuizScreen(navController: NavController, categoryId: Int) {
    val flashLearnText = "FlashLearn"
    val colors = listOf(
        Color(0xFF90A4AE),
        Color(0xFFC2E4EF),
        Color(0xFFF8CBDB),
        Color(0xFFF5ECB9),
        Color(0xFFA7BAC4),
        Color(0xFF1A237E),
        Color(0xFF1A237E),
        Color(0xFF1A237E),
        Color(0xFF1A237E),
        Color(0xFF1A237E)
    )

    val colorfulText = buildAnnotatedString {
        flashLearnText.forEachIndexed { index, c ->
            withStyle(style = SpanStyle(color = colors.getOrElse(index) { Color.Black })) {
                append(c)
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(horizontal = 32.dp)
                    .align(Alignment.Center)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = colorfulText,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Quiz",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Choose a definition that matches the term given.",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(22.dp))

                        Button(
                            onClick = { navController.navigate(Screen.MiniQuiz.createRoute(categoryId)) },
                            modifier = Modifier
                                .wrapContentWidth()
                                .height(40.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF4CAF50)
                            )
                        ) {
                            Text("Start", color = Color.White, fontSize = 16.sp)
                        }
                    }
                }
            }
        }
    }
}