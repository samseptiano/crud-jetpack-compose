package example.samseptiano.roomjetpackcompose.presentation.books.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import example.samseptiano.roomjetpackcompose.core.Constants.Companion.ADD_BOOK

@Composable
fun AddBookFloatingActionButton(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        onClick = openDialog,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ADD_BOOK
        )
    }
}