package com.example.flashlearn.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
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
                    .size(80.dp)
                    .zIndex(1f),
                iconSize = 60.dp,
                contentColor = Color(0xFF3F788C)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                GradientText(text = "FlashLearn", fontSize = 40.sp)
            }

            Text(
                "Supports vocabulary and concept learning.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF8DA9B5),
                modifier = Modifier.padding(top = 2.dp)
            )

            // Search box
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
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
                            tint = Color(0xFF3F788C)
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color(0xFF3F788C),
                        unfocusedIndicatorColor = Color(0xFF3F788C),
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        unfocusedPlaceholderColor = Color(0xFF3F788C),
                        focusedPlaceholderColor = Color(0xFF3F788C),
                        focusedTextColor = Color(0xFF39544F),
                        unfocusedTextColor = Color(0xFF39544F)
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = { viewModel.onSearchSubmit() },
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            color = Color(0xFFCADDEC),
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color(0xFF3F788C)
                    )
                }
            }

            // Search Result
            if (!searchText.isNullOrEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Results displayed by keyword \"$searchText\"",
                        style = TextStyle(fontSize = 14.sp),
                        color = Color(0XFF8DA9B5)
                    )
                    TextButton(onClick = { viewModel.clearSearch() }) {
                        Text(
                            "View all",
                            color = Color(0xFF1A237E),
                            )
                    }
                }
            }

            // Title
            Text(
                "Categories",
                style = TextStyle(
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A237E)
                ),
                modifier = Modifier.padding(top = 10.dp, bottom = 6.dp)
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
                        "There is no category here, press \"+\" to add a new one!"
                    } else {
                        "The category was not found."
                    },
                    onActionClick = null
                )
            }
        }
    }
}