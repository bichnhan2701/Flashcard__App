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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.flashlearn.ui.component.GradientText

@Composable
fun HomeScreen (navController: NavController) {
    val categories = listOf(
        "TOEIC vocab day1" to 20,
        "TOEIC vocab day2" to 23,
        "HSK vocab day1" to 10,
        "HSK vocab day2" to 11
    )

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
                onValueChange = { },
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
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Flashcard Folder list
            LazyColumn {
                items(categories) { (title, count) ->
                    FlashcardFolderItem(title, count)
                }
            }
        }
    }
}