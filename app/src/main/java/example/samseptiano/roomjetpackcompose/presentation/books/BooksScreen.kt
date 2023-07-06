package example.samseptiano.roomjetpackcompose.presentation.books

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import example.samseptiano.roomjetpackcompose.presentation.books.components.AddBookAlertDialog
import example.samseptiano.roomjetpackcompose.presentation.books.components.AddBookFloatingActionButton
import example.samseptiano.roomjetpackcompose.presentation.books.components.BooksContent
import example.samseptiano.roomjetpackcompose.presentation.books.components.BooksTopBar
import example.samseptiano.roomjetpackcompose.presentation.books.components.SearchWidgetState

@Composable
@ExperimentalMaterialApi
fun BooksScreen(
    viewModel: BooksViewModel = hiltViewModel(),
    navigateToUpdateBookScreen: (bookId: Int) -> Unit,
    navigateToSettingScreen: () -> Unit
) {

    var searchWidgetState by remember {
        mutableStateOf(SearchWidgetState.CLOSED)
    }
    var searchTextState by remember {
        mutableStateOf("")
    }

    var favoriteState by remember {
        mutableStateOf(false)
    }

    viewModel.bookList = viewModel.books.collectAsState(initial = emptyList()).value
    viewModel.bookListSearch = viewModel.books.collectAsState(initial = emptyList()).value


    Scaffold(
        topBar = {
            BooksTopBar(
                navigateToSettingScreen = navigateToSettingScreen,
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = {
                    searchTextState = it
                    viewModel.searchBook(it)

                },
                onCloseClicked = {
                    searchWidgetState = SearchWidgetState.CLOSED
                },
                onSearchClicked = {

                },
                onFavoriteClicked = {
                    favoriteState = !favoriteState
                    viewModel.showFavoriteOnly(favoriteState)
                    favoriteState
                },
                onSearchTriggered = {
                    searchWidgetState = SearchWidgetState.OPENED
                }
            )
        },
        content = { padding ->
            BooksContent(
                padding = padding,
                books = viewModel.bookListSearch,
                deleteBook = { book ->
                    viewModel.deleteBook(book)
                },
                favoriteBook = { book ->
                    viewModel.updateBook(book)

                },
                navigateToUpdateBookScreen = navigateToUpdateBookScreen,
                viewModel.loading
            )
            AddBookAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addBook = { book ->
                    viewModel.addBook(book)
                }
            )
        },
        floatingActionButton = {
            AddBookFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}