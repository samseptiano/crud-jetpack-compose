package example.samseptiano.roomjetpackcompose.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import example.samseptiano.roomjetpackcompose.data.dao.BookDao
import example.samseptiano.roomjetpackcompose.domain.model.Book

@Database(
    entities = [Book::class],
    version = 1,
    exportSchema = false
)
abstract class BookDb : RoomDatabase() {
    abstract val bookDao: BookDao
}