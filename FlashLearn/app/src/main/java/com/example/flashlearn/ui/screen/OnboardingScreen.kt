package com.example.flashlearn.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.flashlearn.R

// Màn hình hướng dẫn Onboarding
@Composable
fun OnboardingScreen(
    onSkip: () -> Unit,
    onDone: () -> Unit
) {
    val pages = listOf(
        OnboardingPage(
            "Chào mừng đến với FlashLearn!",
            "Khám phá một cách học mới với Flashcard Learning! Ngắn gọn, dễ nhớ, giúp bạn ghi nhớ lâu hơn và học tập hiệu quả!",
            R.raw.hello_animation
        ),
        OnboardingPage(
            "Tại sao bạn nên chọn FlashLearn?",
            "FlashLearn có thể khắc phục các vấn đề mà bạn gặp phải trong việc học, giúp bạn ghi nhớ lâu hơn, học tập hiệu quả và tiết kiệm thời gian.",
            R.raw.card_animation
        ),
        OnboardingPage(
            "Hãy bắt đầu cùng FlashLearn ngay!",
            "Bắt đầu hành trình học tập của bạn ngay hôm nay! Học mọi lúc, mọi nơi, và chinh phục tri thức mới.",
            R.raw.start_animation
        )
    )

    var currentPage by rememberSaveable { mutableIntStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            OnboardingContent(page = pages[currentPage])

            DotIndicator(
                totalDots = pages.size,
                selectedIndex = currentPage
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (currentPage > 0) {
                    TextButton(onClick = { currentPage-- }) {
                        Text("Trở lại")
                    }
                } else {
                    Spacer(modifier = Modifier.width(64.dp))
                }

                Button(onClick = {
                    if (currentPage < pages.size - 1) {
                        currentPage++
                    } else {
                        onDone()
                    }
                }) {
                    Text(text = if (currentPage == pages.size - 1) "Bắt đầu" else "Tiếp tục")
                }
            }
        }

        // Nút Skip ở góc trên phải
        TextButton(
            onClick = onSkip,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Text("Bỏ qua")
        }
    }
}

data class OnboardingPage(
    val title: String,
    val description: String,
    val animationResId: Int
)

@Composable
fun OnboardingContent(page: OnboardingPage) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(page.animationResId))
    val progress by animateLottieCompositionAsState(composition)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = page.title,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = page.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DotIndicator(totalDots: Int, selectedIndex: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(totalDots) { index ->
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .padding(4.dp)
                    .background(
                        color = if (index == selectedIndex) Color(0xFF2196F3) else Color.Gray,
                        shape = CircleShape
                    )
            )
        }
    }
}