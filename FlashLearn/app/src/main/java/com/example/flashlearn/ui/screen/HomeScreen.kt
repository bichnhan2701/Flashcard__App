package com.example.flashlearn.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.flashlearn.navigation.Screen
import com.example.flashlearn.ui.component.*
import com.example.flashlearn.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val searchQuery by viewModel.searchInput.collectAsState()
    val searchText by viewModel.searchQuery.collectAsState()
    val categories by viewModel.filteredCategories.collectAsState()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        floatingActionButton = {
            ActionButton(
                text = null,
                icon = Icons.Default.Add,
                onClick = {
                    navController.navigate(Screen.Add.route)
                },
                modifier = Modifier
                    .size(72.dp)
                    .zIndex(1f),
                iconSize = 40.dp
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                GradientText(text = "FlashLearn", fontSize = 40.sp)
                IconButton(
                    onClick = { navController.navigate(Screen.Notification.route) }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Thông báo",
                        tint = Color.Gray
                    )
                }
            }

            Text(
                "Supports vocabulary and concept learning.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )

            // Search box
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = viewModel::onSearchInputChanged,
                    placeholder = { Text("Search...") },
                    modifier = Modifier
                        .weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Search,
                            contentDescription = null,
                            tint = Color(0xFF0F81DA)
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color(0xFF0F81DA),
                        unfocusedIndicatorColor = Color(0xFF0F81DA),
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = { viewModel.onSearchSubmit() },
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            color = Color(0xFFE3F2FD),
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color(0xFF0F81DA)
                    )
                }
            }

            // Search Result
            if (!searchText.isNullOrEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Kết quả hiển thị theo từ khóa \"$searchText\"",
                        style = TextStyle(fontSize = 14.sp),
                        color = Color.Gray
                    )
                    TextButton(onClick = { viewModel.clearSearch() }) {
                        Text("Xem tất cả")
                    }
                }
            }

            // Title
            Text(
                "Flashcard categories",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // List Flashcards
            if (categories.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(categories) { category ->
                        FlashcardFolderItem(
                            title = category.name,
                            count = category.cardCount,
                            onClick = {
                                navController.navigate(Screen.FolderDetail.passCategoryId(category.id))
                            }
                        )
                    }
                }
            } else {
                EmptyView(
                    message = if (searchText.isNullOrEmpty()) {
                        "Chưa có bộ thẻ nào, hãy nhấn \"+\" để thêm bộ thẻ mới"
                    } else {
                        "Không tìm thấy bộ thẻ này"
                    },
                    onActionClick = null
                )
            }
        }
    }
}
