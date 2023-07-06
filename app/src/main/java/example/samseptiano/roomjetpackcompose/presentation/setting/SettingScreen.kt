package example.samseptiano.roomjetpackcompose.presentation.setting

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import example.samseptiano.roomjetpackcompose.presentation.setting.components.SettingTopBar

@Composable
@ExperimentalMaterialApi
fun SettingScreen(
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            SettingTopBar(
                navigateBack = navigateBack
            )
        },
        content = {}
    )
}