package com.example.flashlearn.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flashlearn.domain.model.Flashcard

@Composable
fun DynamicFlashcardList(
    flashcards: List<Flashcard>,
    onFlashcardChange: (Int, Flashcard) -> Unit = { _, _ -> },
    onAddFlashcard: () -> Unit = {},
    onRemoveFlashcard: (Int) -> Unit = {},
    readOnly: Boolean = false,
    modifier: Modifier = Modifier
) {
    // Kiểm tra xem có ít hơn 2 flashcard không để vô hiệu hóa khả năng xóa
    val canDeleteFlashcard = flashcards.size > 2

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(flashcards) { index, flashcard ->
            CardItem(
                term = flashcard.term,
                definition = flashcard.definition,
                onTermChange = { newTerm -> onFlashcardChange(index, flashcard.copy(term = newTerm))},
                onDefinitionChange = { newDef -> onFlashcardChange(index, flashcard.copy(definition = newDef))},
                onDelete = { onRemoveFlashcard(index) },
                canDelete = canDeleteFlashcard,
                readOnly = false
            )
        }

        if (!readOnly) {
            item {
                Spacer(Modifier.height(8.dp))
                ActionButton(
                    text = "Thêm flashcard",
                    icon = Icons.Default.Add,
                    onClick = onAddFlashcard,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}
