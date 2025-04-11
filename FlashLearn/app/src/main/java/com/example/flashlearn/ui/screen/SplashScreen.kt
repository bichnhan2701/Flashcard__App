package com.example.flashlearn.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.flashlearn.R
import com.example.flashlearn.data.repository.PreferencesRepository
import com.example.flashlearn.navigation.Screen
import kotlinx.coroutines.delay

//Màn hình Splash
@Composable
fun SplashScreen(navController: NavHostController, preferences: PreferencesRepository) {
//    val context = LocalContext.current
//    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        val seenOnboarding = preferences.hasSeenOnboarding()
        delay(1500)
        if (seenOnboarding) {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        } else {
            navController.navigate(Screen.Onboarding.route) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logoflashlearn),
            contentDescription = "FlashLearn Logo",
            modifier = Modifier
                .size(180.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

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

        Row {
            text.forEachIndexed { index, char ->
                Text(
                    text = char.toString(),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors[index % colors.size]
                )
            }
        }
    }
}
