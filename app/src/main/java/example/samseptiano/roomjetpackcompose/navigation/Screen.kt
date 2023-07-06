package example.samseptiano.roomjetpackcompose.navigation

import example.samseptiano.roomjetpackcompose.core.Constants.Companion.BOOKS_SCREEN
import example.samseptiano.roomjetpackcompose.core.Constants.Companion.SETTING_SCREEN
import example.samseptiano.roomjetpackcompose.core.Constants.Companion.UPDATE_BOOK_SCREEN

sealed class Screen(val route: String) {
    object BooksScreen: Screen(BOOKS_SCREEN)
    object UpdateBookScreen: Screen(UPDATE_BOOK_SCREEN)
    object SettingScreen: Screen(SETTING_SCREEN)
}