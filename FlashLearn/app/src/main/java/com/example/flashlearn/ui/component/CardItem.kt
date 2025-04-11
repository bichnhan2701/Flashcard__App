package com.example.flashlearn.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.Icon
import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.OutlinedTextField

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardItem(
    term: String,
    definition: String,
    onTermChange: (String) -> Unit,
    onDefinitionChange: (String) -> Unit,
    onDelete: () -> Unit,
    canDelete: Boolean
) {
    val dismissState = rememberDismissState(
        confirmStateChange = {
            if (it == DismissValue.DismissedToStart && canDelete) {
                onDelete()
                true
            } else {
                false
            }
        }
    )

    SwipeToDismiss(
        state = dismissState,
        directions = if (canDelete) setOf(DismissDirection.EndToStart) else emptySet(),
        background = {
            val backgroundColor =
                if (dismissState.targetValue == DismissValue.DismissedToStart) Color.Red else Color(0xFFD5E7F7)

            // Thêm chiều cao cố định để nền match chiều cao nội dung (Card)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp), // Giống padding của Card
                    //.height(IntrinsicSize.Min), // Tự khớp chiều cao với content
                contentAlignment = Alignment.CenterEnd
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(backgroundColor)
                        .padding(horizontal = 20.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    if (canDelete) {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Delete Icon",
                            tint = Color.White
                        )
                    }
                }
            }
        },
        dismissContent = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(12.dp)
                ) {
                    OutlinedTextField(
                        value = term,
                        onValueChange = onTermChange,
                        placeholder = { Text("Term") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF6587A2),
                            unfocusedBorderColor = Color(0xFF8DA9B5),
                            cursorColor = Color(0xFF6587A2),
                            focusedLabelColor = Color(0xFF8DA9B5)
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = definition,
                        onValueChange = onDefinitionChange,
                        placeholder = { Text("Definition") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF6587A2),
                            unfocusedBorderColor = Color(0xFF8DA9B5),
                            cursorColor = Color(0xFF6587A2),
                            focusedLabelColor = Color(0xFF8DA9B5)
                        )
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CardItemPreview() {
    CardItem("", "", onDelete = {}, onTermChange = {}, onDefinitionChange = {}, canDelete = true)
}
