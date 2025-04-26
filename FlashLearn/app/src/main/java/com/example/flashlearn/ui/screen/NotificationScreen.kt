package com.example.flashlearn.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.flashlearn.ui.component.DeleteConfirmationDialog
import com.example.flashlearn.ui.viewmodel.NotificationViewModel

@Composable
fun NotificationScreen(
    navController: NavController,
    viewModel: NotificationViewModel = hiltViewModel()
) {
    var showDeleteDialog by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "Back")
        }
        Text(
            text = "Thông báo",
            style = MaterialTheme.typography.headlineSmall
        )

        TextButton(onClick = {  }) {
            Text("Xoá tất cả", color = MaterialTheme.colorScheme.error)
        }
    }
//    Scaffold(
//        topBar = {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                IconButton(onClick = { navController.popBackStack() }) {
//                    Icon(Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "Back")
//                }
//                Text(
//                    text = "Thông báo",
//                    style = MaterialTheme.typography.headlineSmall
//                )
//
//                TextButton(onClick = {  }) {
//                    Text("Xoá tất cả", color = MaterialTheme.colorScheme.error)
//                }
//            }
//        },
//        bottomBar = {
//            Button(
//                onClick = {  },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text("Đánh dấu tất cả là đã đọc")
//            }
//        }
//    ) { padding ->
//        if (notifications.isEmpty()) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(padding),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text("Không có thông báo nào.")
//            }
//        } else {
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(padding)
//            ) {
//                items(notifications) { notification ->
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        // Icon trạng thái đã đọc
//                        Icon(
//                            imageVector = if (notification.isRead) Icons.Default.CheckCircle else Icons.Default.Clear,
//                            contentDescription = if (notification.isRead) "Đã đọc" else "Chưa đọc",
//                            tint = if (notification.isRead) Color.Gray else MaterialTheme.colorScheme.primary,
//                            modifier = Modifier.size(20.dp)
//                        )
//
//                        Spacer(modifier = Modifier.width(12.dp))
//
//                        Column(modifier = Modifier.weight(1f)) {
//                            Text(
//                                text = notification.title,
//                                style = MaterialTheme.typography.titleMedium,
//                                fontWeight = if (notification.isRead) FontWeight.Normal else FontWeight.Bold
//                            )
//                            Text(
//                                text = notification.message,
//                                style = MaterialTheme.typography.bodyMedium,
//                                color = Color.Gray
//                            )
//                            Text(
//                                text = formatDate(notification.timestamp),
//                                style = MaterialTheme.typography.labelSmall,
//                                color = Color.LightGray
//                            )
//                        }
//                    }
//                }
//            }
//        }

        // Dialog xác nhận xoá
        DeleteConfirmationDialog(
            showDialog = showDeleteDialog,
            onConfirmDelete = {
                showDeleteDialog = false
    //                viewModel.deleteAllNotifications()
            },
            onDismiss = { showDeleteDialog = false },
            title = "Xoá tất cả thông báo?",
            message = "Bạn có chắc chắn muốn xoá toàn bộ thông báo không?",
            confirmText = "Xoá hết",
            dismissText = "Hủy"
        )
    //}
}