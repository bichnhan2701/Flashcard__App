package com.example.flashlearn.ui.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.flashlearn.R
import com.example.flashlearn.domain.model.Flashcard
import com.example.flashlearn.navigation.Screen
import com.example.flashlearn.ui.component.DeleteConfirmationDialog
import com.example.flashlearn.ui.component.DynamicFlashcardList
import com.example.flashlearn.ui.component.ExitConfirmationDialog
import com.example.flashlearn.ui.component.SaveSuccessDialog
import com.example.flashlearn.ui.viewmodel.EditFolderDetailViewModel

@Composable
fun EditFolderDetailScreen(
    navController: NavController,
    categoryId: Int,
    viewModel: EditFolderDetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    var categoryName by rememberSaveable { mutableStateOf("") }
    var flashcardList by rememberSaveable { mutableStateOf(listOf<Flashcard>()) }

    var showExitDialog by remember { mutableStateOf(false) }
    var showSaveSuccessDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.loadFolderDetail(categoryId)
    }

    val folderDetail by viewModel.folderDetail.collectAsState()

    LaunchedEffect(folderDetail) {
        folderDetail?.let { detail ->
            categoryName = detail.name
            flashcardList = detail.flashcards
        }
    }

    Scaffold(
        topBar = {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                EditHeaderIcons(
                    onCancel = { showExitDialog = true },
                    onSave = {
                        if (categoryName.isBlank()) {
                            Toast.makeText(context, "Tên thư mục không được để trống", Toast.LENGTH_SHORT).show()
                        } else if (flashcardList.size < 2) {
                            Toast.makeText(context, "Cần ít nhất 2 flashcard", Toast.LENGTH_SHORT).show()
                        } else {
                            viewModel.updateFolder(
                                categoryId = categoryId,
                                updatedName = categoryName,
                                updatedCards = flashcardList
                            )
                            showSaveSuccessDialog = true
                        }
                    },
                    onDelete = {
                        showDeleteDialog = true
                    }

                )
            }
        }
    ) { padding ->
    Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = categoryName,
                onValueChange = { categoryName = it },
                label = { Text("Tên thư mục") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // DynamicFlashcardList now handles adding flashcards
            DynamicFlashcardList(
                flashcards = flashcardList,
                onFlashcardChange = { index, updatedFlashcard ->
                    flashcardList = flashcardList.toMutableList().apply {
                        this[index] = updatedFlashcard
                    }
                },
                onAddFlashcard = {
                    flashcardList = flashcardList + Flashcard(
                        id = 0, // Giả sử ID là 0 và sẽ được cập nhật khi lưu
                        categoryId = categoryId,
                        term = "",
                        definition = "",
                        pronunciation = null,
                        isFavorite = false,
                        createdAt = System.currentTimeMillis(),
                        updatedAt = System.currentTimeMillis()
                    )
                },
                onRemoveFlashcard = { index ->
                    if (flashcardList.size > 2) {
                        flashcardList = flashcardList.toMutableList().apply {
                            removeAt(index)
                        }
                    }
                },
                readOnly = false
            )
        }
    }
    // Dialog xác nhận thoát nếu chưa lưu
    ExitConfirmationDialog(
        showDialog = showExitDialog,
        onConfirmExit = {
            navController.popBackStack()
        },
        onDismiss = {
            showExitDialog = false
        }
    )
    // Dialog lưu thành công
    SaveSuccessDialog(
        showDialog = showSaveSuccessDialog,
        onDismiss = {
            showSaveSuccessDialog = false
            navController.popBackStack()
        }
    )
    // Dialog xóa thành công
    DeleteConfirmationDialog(
        showDialog = showDeleteDialog,
        onConfirmDelete = {
            viewModel.deleteFolder(categoryId)
            showDeleteDialog = false
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Home.route) { inclusive = true }
            }
        },
        onDismiss = { showDeleteDialog = false }
    )

}

@Composable
fun EditHeaderIcons(onCancel: () -> Unit, onSave: () -> Unit, onDelete: () -> Unit) {
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
            painter = painterResource(R.drawable.delete_2_svgrepo_com),
            contentDescription = "Delete",
            modifier = Modifier
                .padding(end = 30.dp)
                .clickable { onDelete() }
        )
        Icon(
            painter = painterResource(R.drawable.mingcute_save_line),
            contentDescription = "Save",
            modifier = Modifier
                .size(36.dp)
                .clickable { onSave() }
        )
    }
}