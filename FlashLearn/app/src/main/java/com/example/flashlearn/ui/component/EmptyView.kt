package com.example.flashlearn.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashlearn.R
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun EmptyView (
    message: String,
    animationResource: Int = R.raw.nothing_animation,
    onActionClick: (() -> Unit)? = null,
    actionLabel: String = "Tạo Folder",
    modifier: Modifier = Modifier
){
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(animationResource))

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            composition = composition,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            message,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (onActionClick != null) {
            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = onActionClick) {
//                Text(actionLabel)
//            }
            ActionButton(
                text = actionLabel,
                onClick = onActionClick
            )
        }
    }
}