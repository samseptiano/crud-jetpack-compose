package example.samseptiano.roomjetpackcompose.presentation.books

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import example.samseptiano.roomjetpackcompose.core.Constants.Companion.EMPTY_STRING
import example.samseptiano.roomjetpackcompose.domain.model.Book
import example.samseptiano.roomjetpackcompose.domain.repository.BookRepository
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val repo: BookRepository
) : ViewModel() {
    var book by mutableStateOf(Book(0, EMPTY_STRING, EMPTY_STRING))
        private set

    var bookList by mutableStateOf(listOf<Book>())

    var bookListSearch by mutableStateOf(listOf<Book>())

    var loading by mutableStateOf(false)
        private set

    var openDialog by mutableStateOf(false)

    val books = repo.getBooksFromRoom()


    fun getBook(id: Int) = viewModelScope.launch {
        book = repo.getBookFromRoom(id)
    }

    fun addBook(book: Book) = viewModelScope.launch {
        repo.addBookToRoom(book)
    }

    fun updateBook(book: Book) = viewModelScope.launch {
        showLoading()
        repo.updateBookInRoom(book)
        val oldData = bookList.find { p -> p.id == book.id }
        delay(500)
        hideLoading()
    }

    fun searchBook(query: String) {
        bookListSearch = if (query.isEmpty() || query.isBlank()) {
            bookList
        } else {
            bookList.filter { p -> p.title.contains(query, true) }
        }
    }

    fun showFavoriteOnly(showFavorite:Boolean) = viewModelScope.launch {
        showLoading()
        bookListSearch = if(showFavorite) {
            bookList.filter { p -> p.isFavorite }
        } else{
            bookList
        }
        delay(500)
        hideLoading()
    }

    fun deleteBook(book: Book) = viewModelScope.launch {
        showLoading()
        repo.deleteBookFromRoom(book)
        hideLoading()
    }

    fun updateTitle(title: String) {
        book = book.copy(
            title = title
        )
    }

    fun updateAuthor(author: String) {
        book = book.copy(
            author = author
        )
    }

    fun updateIsFavorite(isFavorite: Boolean) {
        book = book.copy(
            isFavorite = isFavorite
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun showLoading() {
        loading = true
    }

    private fun hideLoading() {
        loading = false
    }
}
