package example.samseptiano.roomjetpackcompose.presentation.books.components

import android.util.Log
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import example.samseptiano.roomjetpackcompose.core.Constants.Companion.BOOKS_SCREEN

@Composable
fun BooksTopBar(
    navigateToSettingScreen: () -> Unit,

    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit,
    onFavoriteClicked: () -> Boolean

) {
    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            DefaultAppBar(
                onSearchClicked = {
                    onSearchTriggered()
                },
                onFavoriteClicked = onFavoriteClicked,
                navigateToSettingScreen = navigateToSettingScreen
            )
        }

        SearchWidgetState.OPENED -> {
            BooksSearchBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClicked
            )
        }
    }


}

@Composable
fun DefaultAppBar(
    onSearchClicked: () -> Unit,
    onFavoriteClicked: () -> Boolean,
    navigateToSettingScreen: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = BOOKS_SCREEN
            )
        },
        actions = {
            IconButton(
                onClick = { onSearchClicked() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = Color.White
                )
            }
            IconButton(
                onClick = {
                    onFavoriteClicked()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Favorite Icon",
                    tint = Color.White
                )


            }
            BooksOverflowMenu {
                DropdownMenuItem(onClick = {
                    Log.d("menu setting", "here")
                    navigateToSettingScreen.invoke()
                }) {
                    Text("Settings")
                }
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text("Bookmarks")
                }
            }
        },
    )
}