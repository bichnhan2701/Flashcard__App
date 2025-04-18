package com.example.flashlearn.ui.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
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
fun ReviewCard(
    viewModel: FlashcardReviewViewModel,
    onBack: () -> Unit
) {
    val flashcard = viewModel.currentFlashcard
    val progress = viewModel.reviewProgress
    val currentIndex by viewModel.currentIndex
    val totalCount = viewModel.flashcards.size
    val countText = "${currentIndex + 1} / $totalCount"

    if (flashcard == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Không có flashcard để học", style = MaterialTheme.typography.bodyLarge)
        }
        return
    }
    var rotation by remember { mutableFloatStateOf(0f) }
    val animatedRotation by animateFloatAsState(targetValue = rotation, label = "card rotation")
    val isBackVisible = viewModel.isFlipped.value

    val previousCardIndex = remember { mutableIntStateOf(-1) }
    if (previousCardIndex.intValue != currentIndex) {
        previousCardIndex.intValue = currentIndex
        rotation = 0f // reset mặt trước mỗi khi card mới
        viewModel.setIsFront(true) // dùng để quản lý logic nếu cần
    }

    val offsetX = remember { Animatable(0f) }
    val swipeThreshold = 200f
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = countText,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        // Flashcard
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragStart = {
                            scope.launch {
                                offsetX.updateBounds(-1000f, 1000f)
                            }
                        },
                        onDrag = { change, dragAmount ->
                            change.consume()
                            scope.launch {
                                offsetX.snapTo(offsetX.value + dragAmount.x)
                            }
                        },
                        onDragEnd = {
                            scope.launch {
                                when {
                                    offsetX.value < -swipeThreshold -> {
                                        offsetX.animateTo(-1000f)
                                        viewModel.nextFlashcard()
                                        offsetX.snapTo(0f)
                                    }

                                    offsetX.value > swipeThreshold -> {
                                        offsetX.animateTo(1000f)
                                        viewModel.nextFlashcard()
                                        offsetX.snapTo(0f)
                                    }
                                    else -> {
                                        offsetX.animateTo(0f)
                                    }
                                }
                            }
                        },
                        onDragCancel = {
                            scope.launch {
                                offsetX.animateTo(0f)
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
                    .graphicsLayer {
                        rotationY = animatedRotation % 360
                        cameraDistance = 12 * density
                    },
                contentAlignment = Alignment.Center
            ) {
                if (!isBackVisible) {
                    // Front side (term)
                    Text(
                        text = flashcard.term,
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(32.dp)
                    )
                } else {
                    // Back side (definition)
                    Text(
                        text = flashcard.definition,
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(32.dp)
                            .graphicsLayer {
                                rotationY = 180f // lật lại chữ về đúng chiều
                            }
                    )
                }
            }
        }
        // Progress bar
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${(progress * 100).toInt()}% đã nhớ",
                style = MaterialTheme.typography.labelLarge
            )
        }
        // Action buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    viewModel.rememberCurrentFlashcard()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Remember"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Đã nhớ")
            }
        }
    }
}