package com.example.flashlearn.ui.screen

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flashlearn.R
import com.example.flashlearn.ui.viewmodel.AddFolderViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flashlearn.ui.component.DynamicFlashcardList
import com.example.flashlearn.ui.component.ExitConfirmationDialog
import com.example.flashlearn.ui.component.SaveSuccessDialog
import com.example.flashlearn.ui.viewmodel.CreateFolderState
import com.example.flashlearn.ui.viewmodel.FlashcardFormViewModel
import com.example.flashlearn.utils.defaultFlashcards

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AddNewFolderScreen(
    viewModel: AddFolderViewModel = hiltViewModel(),
    flashcardFormViewModel: FlashcardFormViewModel = hiltViewModel(),
    navController: NavController
) {
    var name by rememberSaveable { mutableStateOf("") }
    val state by viewModel.state.collectAsState()
    val flashcards by flashcardFormViewModel.flashcards.collectAsState()
    val flashcardErrors by flashcardFormViewModel.errors.collectAsState()

    var showExitDialog by remember { mutableStateOf(false) }
    var showNameError by remember { mutableStateOf(false) }
    var showMinFlashcardError by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }

    // Init flashcards mặc định
    LaunchedEffect(Unit) {
        flashcardFormViewModel.initFlashcards(defaultFlashcards())
    }

    // Lắng nghe sự kiện lưu thành công
    LaunchedEffect(state) {
        if (state is CreateFolderState.Success) {
            showSuccessDialog = true
        }
    }

    // Quản lý nút Back
    BackHandler(enabled = viewModel.hasUnsavedChanges.value || flashcardFormViewModel.hasUnsavedChanges.value) {
        showExitDialog = true
    }

    // Dialogs
    ExitConfirmationDialog(
        showDialog = showExitDialog,
        onConfirmExit = { navController.popBackStack() },
        onDismiss = { showExitDialog = false }
    )
    SaveSuccessDialog(
        showDialog = showSuccessDialog,
        onDismiss = {
            showSuccessDialog = false
            navController.popBackStack()
        }
    )

    // Hiển thị snackbar lỗi
    if (showNameError) {
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar("Tên folder không được để trống")
            showNameError = false
        }
    }
    if (showMinFlashcardError) {
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar("Phải có ít nhất 2 flashcard")
            showMinFlashcardError = false
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFDAEAF7))
                .padding(padding)
                .padding(16.dp)
        ) {
            // Header: Cancel + Save buttons
            AddHeaderIcons(
                onCancel = { showExitDialog = true },
                onSave = {
                    val isValid = flashcardFormViewModel.validate()
                    when {
                        name.isBlank() -> showNameError = true
                        !isValid -> {} // Flashcard error hiển thị bên dưới
                        else -> viewModel.createFolder(name, flashcardFormViewModel.getFlashcards())
                    }
                }
            )
            Spacer(modifier = Modifier.height(32.dp))

            // Folder name input
            Text("Folder name", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    viewModel.setUnsavedChanges(true)
                },
                label = { Text("Tên Folder") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Flashcard section
            Text("Cards", style = MaterialTheme.typography.titleMedium)
            Text("(At least two cards)", color = Color.DarkGray, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
            DynamicFlashcardList(
                flashcards = flashcards,
                onFlashcardChange = { index, updated -> flashcardFormViewModel.updateCard(index, updated) },
                onAddFlashcard = { flashcardFormViewModel.addCard() },
                onRemoveFlashcard = { index ->
                    val ok = flashcardFormViewModel.removeCard(index)
                    if (!ok) showMinFlashcardError = true
                },
                readOnly = false
            )
            // Hiển thị lỗi flashcard
            flashcardErrors.forEach { (i, err) ->
                if (err.first || err.second) {
                    Text(
                        "Flashcard ${i + 1}: ${if (err.first) "thiếu thuật ngữ " else ""}${if (err.second) "thiếu định nghĩa" else ""}",
                        color = Color.Red,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            // Lỗi hệ thống nếu có
            if (state is CreateFolderState.Error) {
                Text((state as CreateFolderState.Error).message, color = Color.Red)
            }
        }
    }
}

@Composable
fun AddHeaderIcons(onCancel: () -> Unit, onSave: () -> Unit) {
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
                .clickable { onSave() }
        )
    }
}