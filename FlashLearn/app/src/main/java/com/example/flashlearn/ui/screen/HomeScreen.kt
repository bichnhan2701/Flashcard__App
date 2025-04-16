package com.example.flashlearn.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flashlearn.ui.component.BottomNavigationBar
import com.example.flashlearn.ui.component.FlashcardFolderItem
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flashlearn.navigation.Screen
import com.example.flashlearn.ui.component.BottomNavItem
import com.example.flashlearn.ui.component.EmptyView
import com.example.flashlearn.ui.component.GradientText
import com.example.flashlearn.ui.viewmodel.HomeViewModel
import java.net.URLEncoder

@Composable
fun HomeScreen (
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val categories by viewModel.categories.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
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
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Outlined.Notifications, contentDescription = "Thông báo")
                }
            }

            Text(
                "Supports vocabulary and concept learning.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )

            // Search box
            OutlinedTextField(
                value = "",
                onValueChange = {  },
                placeholder = { Text("Search...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .padding(vertical = 16.dp),
                leadingIcon = {
                    Icon(Icons.Outlined.Search, contentDescription = null)
                }
            )

            Text(
                "Flashcard categories",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Folder list
            LazyColumn {
                items(categories) { category ->
                    FlashcardFolderItem(
                        title = category.name,
                        count = category.cardCount,
                        onClick = {
                            navController.navigate(Screen.FolderDetail.passCategoryId(category.id))
                        }
                    )
                }
                if (categories.isEmpty()) {
                    item {
                        EmptyView(
                            message = "Chưa có folder nào. Hãy tạo mới!",
                            onActionClick = {
                                navController.navigate(BottomNavItem.Add.route)
                            }
                        )
                    }
                }
            }
        }
    }
}