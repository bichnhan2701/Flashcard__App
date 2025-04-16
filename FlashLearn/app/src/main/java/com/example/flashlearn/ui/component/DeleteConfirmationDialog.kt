package com.example.flashlearn.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun DeleteConfirmationDialog(
    showDialog: Boolean,
    onConfirmDelete: () -> Unit,
    onDismiss: () -> Unit,
    title: String = "Xác nhận xoá",
    message: String = "Bạn có chắc chắn muốn xoá mục này?",
    confirmText: String = "Xoá",
    dismissText: String = "Hủy"
) {
    if (!showDialog) return

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onConfirmDelete) {
                Text(confirmText, color = MaterialTheme.colorScheme.error, fontWeight = FontWeight.Bold)
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