package com.example.flashlearn.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flashlearn.R
import com.example.flashlearn.navigation.Screen
import com.example.flashlearn.ui.component.ActionButton
import com.example.flashlearn.ui.component.GradientText

@Composable
fun StartMiniQuizScreen(navController: NavController, categoryId: Int) {
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
                        GradientText("FlashLearn", 36.sp)

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "Mini Quiz",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Choose a term that matches the definition given.",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            ActionButton(
                                text = "Back",
                                icon = Icons.AutoMirrored.Filled.ArrowBack,
                                onClick = { navController.popBackStack() },
                                containerColor = Color(0xFFE0E0E0),
                                contentColor = Color.Black,
                                iconBackgroundColor = Color.Gray
                            )

                            ActionButton(
                                text = "Start",
                                icon = Icons.Default.PlayArrow,
                                onClick = { navController.navigate(Screen.MiniQuiz.createRoute(categoryId)) },
                                containerColor = Color(0xFF4CAF50),
                                contentColor = Color.White,
                                iconBackgroundColor = Color(0xFF388E3C)
                            )
                        }
                    }
                }
            }
        }
    }
}