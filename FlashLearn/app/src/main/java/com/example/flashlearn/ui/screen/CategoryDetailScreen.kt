package com.example.flashlearn.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.flashlearn.navigation.Screen
import com.example.flashlearn.ui.component.ActionButton
import com.example.flashlearn.ui.component.CardItem
import com.example.flashlearn.ui.viewmodel.CategoryDetailViewModel

@Composable
fun FolderDetailScreen(
    categoryId: Int,
    navController: NavController,
    viewModel: CategoryDetailViewModel = hiltViewModel()
) {
    val flashcards by viewModel.flashcards.collectAsState()
    val name by viewModel.categoryName.collectAsState()

    LaunchedEffect(categoryId) {
        viewModel.load(categoryId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDDEDEA))
            .padding(16.dp)
    ) {
        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(30.dp)
                )
            }
            IconButton(onClick = {
                navController.navigate(Screen.EditFolderDetail.passCategoryId(categoryId))
            }) {
                Icon(
                    Icons.Outlined.Edit,
                    contentDescription = "Edit",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        // Title & card count
        Text(
            text = name,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF39544F)
            ),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "${flashcards.size} cards",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                color = Color(0xFF3F788C)
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ActionButton(text = "Review", icon = Icons.Outlined.MailOutline, onClick = {
                navController.navigate(Screen.FlashcardReview.passCategoryId(categoryId))
            })
            ActionButton(text = "Mini quiz", icon = Icons.Outlined.Create, onClick = {
                navController.navigate(Screen.StartMiniQuiz.createRoute(categoryId))

            })
        }
        // Card List
        Text(
            text = "Cards",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF39544F)
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(flashcards) { _, card ->
                CardItem(
                    term = card.term,
                    definition = card.definition,
                    isFavorite = card.isFavorite,
                    onFavoriteClick = { viewModel.toggleFavorite(card) },
                    canDelete = false,
                    readOnly = true
                )
            }
        }
    }
}