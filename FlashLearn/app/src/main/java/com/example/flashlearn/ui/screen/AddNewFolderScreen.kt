package com.example.flashlearn.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashlearn.R
import com.example.flashlearn.ui.component.ActionButton
import com.example.flashlearn.ui.component.CardItem

@Composable
fun AddNewFolderScreen(
    onCancel: () -> Unit = {}
) {
    var folderName by remember { mutableStateOf("") }
    var cards by remember {
        mutableStateOf(
            listOf(
                CardInput("", ""),
                CardInput("", "")
            )
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDAEAF7))
            .padding(16.dp)
    ) {
        item {
            // Header với Save và Cancel icons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.close),
                    contentDescription = "Cancel",
                    modifier = Modifier
                        .padding(end = 30.dp)
                        .size(36.dp)
                        .clickable { onCancel() }
                )

                Icon(
                    painter = painterResource(R.drawable.mingcute_save_line),
                    contentDescription = "Save",
                    modifier = Modifier
                        .size(36.dp)
                        .clickable {
                            // TODO: handle save
                        }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Folder name",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = folderName,
                onValueChange = { folderName = it },
                placeholder = { Text("Add folder name") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF6587A2),
                    unfocusedBorderColor = Color(0xFF8DA9B5),
                    cursorColor = Color(0xFF6587A2),
                    focusedLabelColor = Color(0xFF8DA9B5)
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Cards",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text("(At least two cards)", color = Color.DarkGray, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
        }

        itemsIndexed(cards) { index, card ->
            CardItem(
                term = card.term,
                definition = card.definition,
                onTermChange = { newTerm ->
                    cards = cards.toMutableList().also { it[index] = it[index].copy(term = newTerm) }
                },
                onDefinitionChange = { newDef ->
                    cards = cards.toMutableList().also { it[index] = it[index].copy(definition = newDef) }
                },
                onDelete = {
                    if (cards.size > 2) {
                        cards = cards.toMutableList().also { it.removeAt(index) }
                    }
                },
                canDelete = cards.size > 2
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            // Add Card Button ở giữa
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                //AddButton { cards = cards + CardInput("", "") }
                ActionButton(
                    text = "Add card",
                    icon = Icons.Default.Add,
                    onClick = { cards = cards + CardInput("", "") }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

data class CardInput(val term: String, val definition: String)

@Preview(showBackground = true)
@Composable
fun AddNewFolderScreenPreview() {
    AddNewFolderScreen(onCancel = {})
}