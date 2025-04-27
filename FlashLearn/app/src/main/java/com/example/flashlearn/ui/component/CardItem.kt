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
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardItem(
    term: String,
    definition: String,
    onTermChange: (String) -> Unit = {},
    onDefinitionChange: (String) -> Unit = {},
    onDelete: () -> Unit = {},
    onFavoriteClick: (() -> Unit)? = null,
    isFavorite: Boolean = false,
    canDelete: Boolean = true,
    readOnly: Boolean = false,
    modifier: Modifier = Modifier
) {
    val dismissState = rememberDismissState(
        confirmStateChange = {
            if (it == DismissValue.DismissedToStart && canDelete) {
                onDelete()
                true
            } else false
        }
    )

    val isSwipeEnabled = canDelete && dismissState.currentValue != DismissValue.DismissedToStart

    SwipeToDismiss(
        state = dismissState,
        directions = if (isSwipeEnabled) setOf(DismissDirection.EndToStart) else emptySet(),
        background = {
            val backgroundColor =
                if (dismissState.targetValue == DismissValue.DismissedToStart) Color.Red else Color.Transparent

            LaunchedEffect(dismissState.currentValue) {
                if (dismissState.currentValue == DismissValue.DismissedToStart && !canDelete) {
                    dismissState.reset()
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(backgroundColor)
                        .padding(horizontal = 20.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    if (isSwipeEnabled) {
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
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(12.dp)
                ) {
                    if (readOnly) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    term,
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xFF313F42)
                                    )
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    definition,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = Color(0xFF313F42)
                                    )
                                )
                            }
                            if (onFavoriteClick != null) {
                                IconButton(onClick = onFavoriteClick) {
                                    Icon(
                                        imageVector = if (isFavorite) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                                        contentDescription = "Favorite",
                                        tint = Color.Red
                                    )
                                }
                            }
                        }
                    } else {
                        OutlinedTextField(
                            value = term,
                            onValueChange = onTermChange,
                            textStyle = TextStyle(
                                fontSize = 18.sp
                            ),
                            placeholder = { Text("Term") },
                            modifier = Modifier.fillMaxWidth(),
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

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = definition,
                            onValueChange = onDefinitionChange,
                            textStyle = TextStyle(
                                fontSize = 18.sp
                            ),
                            placeholder = { Text("Definition") },
                            modifier = Modifier.fillMaxWidth(),
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
                    }
                }
            }
        }
    )
}
