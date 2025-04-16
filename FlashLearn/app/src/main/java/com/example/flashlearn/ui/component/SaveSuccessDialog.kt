package com.example.flashlearn.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SaveSuccessDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    title: String = "Lưu thành công",
    message: String = "Dữ liệu của bạn đã được lưu thành công.",
    buttonText: String = "OK"
) {
    if (!showDialog) return

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(buttonText, fontWeight = FontWeight.Bold)
            }
        },
        title = { Text(title, fontSize = 18.sp, fontWeight = FontWeight.SemiBold) },
        text = { Text(message) }
    )
}