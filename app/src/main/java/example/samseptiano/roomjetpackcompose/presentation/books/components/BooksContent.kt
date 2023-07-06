package example.samseptiano.roomjetpackcompose.presentation.books.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import example.samseptiano.roomjetpackcompose.domain.model.Book
import example.samseptiano.roomjetpackcompose.domain.repository.Books

@Composable
@ExperimentalMaterialApi
fun BooksContent(
    padding: PaddingValues,
    books: Books,
    deleteBook: (book: Book) -> Unit,
    favoriteBook: (book: Book) -> Unit,
    navigateToUpdateBookScreen: (bookId: Int) -> Unit,
    showProgressBar: Boolean
    ) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(
            items = books
        ) { book ->
            BookCard(
                book = book,
                deleteBook = {
                    deleteBook(book)
                },
                favoriteBook = {
                    favoriteBook(book)
                },
                navigateToUpdateBookScreen = navigateToUpdateBookScreen
            )

        }
    }
    if(showProgressBar) {
        LoadingIndicator()
    }
}