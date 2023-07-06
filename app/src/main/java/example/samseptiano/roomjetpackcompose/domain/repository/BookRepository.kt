package example.samseptiano.roomjetpackcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import example.samseptiano.roomjetpackcompose.domain.model.Book

typealias Books = List<Book>

interface BookRepository {
    fun getBooksFromRoom(): Flow<Books>

    suspend fun getBookFromRoom(id: Int): Book

    suspend fun addBookToRoom(book: Book)

    suspend fun updateBookInRoom(book: Book)

    suspend fun deleteBookFromRoom(book: Book)
}