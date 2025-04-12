package com.example.flashlearn.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flashlearn.ui.component.CardItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EditFolderDetailScreen(
    navController: NavController,
    folderTitle: String = "TOEIC vocab day1",
    cardCount: Int = 15
) {
    val cardList = remember {
        mutableStateListOf(
            "establish (v)" to "thành lập",
            "productive (adj)" to "năng suất"
        )
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    cardList.add("" to "")
                },
                containerColor = Color(0xFF4D7ED9),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Card",
                    tint = Color.White
                )
            }
        },
        containerColor = Color(0xFFE1EFF3)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxSize()
        ) {
            // Top App Bar (Back, Edit)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
                IconButton(onClick = {
                    navController.navigate("edit_folder/$folderTitle")
                }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit Folder")
                }
            }

            // Folder title & card count
            Text(
                text = folderTitle,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "${cardList.size} cards",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Section title
            Text(
                text = "Cards",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // List of cards
            LazyColumn {
                itemsIndexed(cardList) { index, card ->
                    CardItem(
                        term = card.first,
                        definition = card.second,
                        onTermChange = { updatedTerm ->
                            cardList[index] = updatedTerm to card.second
                        },
                        onDefinitionChange = { updatedDef ->
                            cardList[index] = card.first to updatedDef
                        },
                        onDelete = {
                            if (cardList.size > 2) cardList.removeAt(index)
                        },
                        canDelete = cardList.size > 2,
                        modifier = Modifier.animateItemPlacement()
                    )
                }
            }
        }
    }
}
