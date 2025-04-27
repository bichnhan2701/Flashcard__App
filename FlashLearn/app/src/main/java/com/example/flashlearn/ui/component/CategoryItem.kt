package com.example.flashlearn.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashlearn.R

// Hiển thị một folder Flashcard trong danh sách
@Composable
fun FlashcardFolderItem(title: String, count: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .background(color = Color(0xFFCADDEC), shape = RoundedCornerShape(10.dp))
            .clickable { onClick() } // gọi onClick khi click
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(color = Color(0xFF3C768A), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.line_md_folder),
                contentDescription = "Folder",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column (
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                title,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF313F42)
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                "$count cards",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                ),
            )
        }
    }
}