package com.example.flashlearn.ui.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.flashlearn.ui.viewmodel.FlashcardReviewViewModel
import kotlinx.coroutines.launch

@Composable
fun ReviewCard(viewModel: FlashcardReviewViewModel, modifier: Modifier) {
    val flashcard = viewModel.currentFlashcard ?: return
    val progress = viewModel.reviewProgress
    val currentIndex by viewModel.currentIndex
    val totalCount = viewModel.flashcards.size
    val countText = "${currentIndex + 1} / $totalCount"
    val isBackVisible = viewModel.isFlipped.value

    var rotation by remember { mutableFloatStateOf(0f) }
    val animatedRotation by animateFloatAsState(targetValue = rotation, label = "card rotation")
    val offsetX = remember { Animatable(0f) }
    val swipeThreshold = 200f
    val scope = rememberCoroutineScope()

    LaunchedEffect(currentIndex) {
        rotation = 0f
        viewModel.setIsFront(true)
    }

    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Flashcard
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .size(350.dp)
                .fillMaxHeight(0.5f)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDrag = { change, dragAmount ->
                            change.consume()
                            scope.launch {
                                offsetX.snapTo(offsetX.value + dragAmount.x)
                            }
                        },
                        onDragEnd = {
                            scope.launch {
                                if (offsetX.value < -swipeThreshold || offsetX.value > swipeThreshold) {
                                    offsetX.animateTo(if (offsetX.value > 0) 1000f else -1000f)
                                    viewModel.nextFlashcard()
                                }
                                offsetX.snapTo(0f)
                            }
                        }
                    )
                }
                .offset { IntOffset(offsetX.value.toInt(), 0) }
                .clickable {
                    rotation += 180f
                    viewModel.flipCard()
                    viewModel.speakTerm()
                },
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .graphicsLayer {
                        rotationY = animatedRotation % 360
                        cameraDistance = 12 * density
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (!isBackVisible) flashcard.term else flashcard.definition,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(32.dp)
                        .graphicsLayer {
                            if (isBackVisible) rotationY = 180f
                        }
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        // Progress
        ProgressBar(progress, countText)
    }
}

@Composable
private fun ProgressBar(progress: Float, countText: String) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = countText, style = MaterialTheme.typography.bodyLarge)
            Text(text = "${(progress * 100).toInt()}% đã nhớ", style = MaterialTheme.typography.labelLarge)
        }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = Color(0xFF37474F), // màu tiến trình đậm
            trackColor = Color(0xFFB0BEC5) // màu nền thanh tiến trình
        )
    }
}