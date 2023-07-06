package example.samseptiano.roomjetpackcompose.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import example.samseptiano.roomjetpackcompose.core.Constants.Companion.BOOK_ID
import example.samseptiano.roomjetpackcompose.navigation.Screen.BooksScreen
import example.samseptiano.roomjetpackcompose.navigation.Screen.UpdateBookScreen
import example.samseptiano.roomjetpackcompose.navigation.Screen.SettingScreen
import example.samseptiano.roomjetpackcompose.presentation.books.BooksScreen
import example.samseptiano.roomjetpackcompose.presentation.setting.SettingScreen
import example.samseptiano.roomjetpackcompose.presentation.update_book.UpdateBookScreen

@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = BooksScreen.route
    ) {
        composable(
            route = BooksScreen.route
        ) {
            BooksScreen(
                navigateToUpdateBookScreen = { bookId ->
                    navController.navigate(
                        route = "${UpdateBookScreen.route}/${bookId}"
                    )
                },
                navigateToSettingScreen = {
                    navController.navigate(
                        route = SettingScreen.route
                    )
                }
            )
        }

        composable(
            route = "${UpdateBookScreen.route}/{$BOOK_ID}",
            arguments = listOf(
                navArgument(BOOK_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt(BOOK_ID) ?: 0
            UpdateBookScreen(
                bookId = bookId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = SettingScreen.route
        ) {
            SettingScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}