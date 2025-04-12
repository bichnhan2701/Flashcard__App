package com.example.flashlearn.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flashlearn.ui.component.ActionButton
import com.example.flashlearn.ui.component.CardViewItem
import java.net.URLEncoder

@Composable
fun FolderDetailScreen(folderName: String, navController: NavController) {
    val count = 15
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
                Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
            }
            Row {
                val encodedName = URLEncoder.encode(folderName, "UTF-8")
                IconButton(onClick = { navController.navigate("edit_folder_detail/$encodedName") }) {
                    Icon(Icons.Outlined.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = { /* TODO: Delete Folder */ }) {
                    Icon(Icons.Outlined.Delete, contentDescription = "Delete")
                }
            }
        }

        // Title & card count
        Text(
            text = folderName,
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "$count cards",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ActionButton(text = "Review", icon = Icons.Outlined.MailOutline, onClick = {})
            ActionButton(text = "Mini quiz", icon = Icons.Outlined.Create, onClick = {})
        }

        // Card List
        Text(
            text = "Cards",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(4) {
                CardViewItem(term = "establish (v)", definition = "thành lập")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FolderDetailScreenPreview() {
    FolderDetailScreen("TOEIC Vocab 1", navController = rememberNavController())
}