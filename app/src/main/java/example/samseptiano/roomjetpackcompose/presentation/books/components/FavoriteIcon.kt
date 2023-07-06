package example.samseptiano.roomjetpackcompose.presentation.books.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import example.samseptiano.roomjetpackcompose.core.Constants.Companion.FAVORITE_BOOK
import example.samseptiano.roomjetpackcompose.domain.model.Book

@Composable
fun FavoriteIcon(
    book: Book,
    favoriteBook: (book: Book) -> Unit
) {
    IconButton(
        onClick = {
            book.isFavorite = !book.isFavorite
            favoriteBook(book)
        }
    ) {
        if(!book.isFavorite) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = FAVORITE_BOOK,
            )
        }
        else{
            Icon(
                imageVector = Icons.Default.Star,
                tint = Color.Red,
                contentDescription = FAVORITE_BOOK,
            )
        }
    }
}