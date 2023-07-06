package example.samseptiano.roomjetpackcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import example.samseptiano.roomjetpackcompose.core.Constants.Companion.BOOK_TABLE
import example.samseptiano.roomjetpackcompose.data.dao.BookDao
import example.samseptiano.roomjetpackcompose.data.network.BookDb
import example.samseptiano.roomjetpackcompose.data.repository.BookRepositoryImpl
import example.samseptiano.roomjetpackcompose.domain.repository.BookRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBookDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        BookDb::class.java,
        BOOK_TABLE
    ).build()

    @Provides
    fun provideBookDao(
        bookDb: BookDb
    ) = bookDb.bookDao

    @Provides
    fun provideBookRepository(
        bookDao: BookDao
    ): BookRepository = BookRepositoryImpl(
        bookDao = bookDao
    )
}