package com.example.flashlearn.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LogoutConfirmationDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        shadowElevation = 8.dp,
    ) {
        AlertDialog(
            containerColor = Color.White,
            shape = RoundedCornerShape(16.dp),
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "Đăng xuất",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            },
            text = {
                Text(
                    text = "Bạn có chắc chắn muốn đăng xuất không?",
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            },
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text(
                        text = "Đăng xuất",
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(
                        text = "Hủy",
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        )
    }
}