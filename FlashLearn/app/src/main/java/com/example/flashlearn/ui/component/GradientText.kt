package com.example.flashlearn.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun GradientText(text: String, fontSize: TextUnit) {
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
                fontSize = fontSize,
                fontWeight = FontWeight.Bold,
                color = colors.getOrElse(index) { colors.last() }
            )
        }
    }
}