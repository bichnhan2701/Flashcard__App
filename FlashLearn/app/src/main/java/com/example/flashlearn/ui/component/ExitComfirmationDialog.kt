package com.example.flashlearn.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ExitConfirmationDialog(
    showDialog: Boolean,
    onConfirmExit: () -> Unit,
    onDismiss: () -> Unit,
    title: String = "Xác nhận thoát",
    message: String = "Bạn có chắc muốn thoát khi chưa lưu?",
    confirmText: String = "Thoát",
    dismissText: String = "Hủy"
) {
    if (!showDialog) return

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onConfirmExit) {
                Text(confirmText, fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(dismissText)
            }
        },
        title = { Text(title, fontSize = 18.sp, fontWeight = FontWeight.SemiBold) },
        text = { Text(message) }
    )
}