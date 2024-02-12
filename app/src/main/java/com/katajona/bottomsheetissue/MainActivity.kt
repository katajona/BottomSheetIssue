package com.katajona.bottomsheetissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.katajona.bottomsheetissue.ui.theme.ComposeNavigationTheme
import com.katajona.bottomsheetissue.navigation.AppNavHost
import com.katajona.bottomsheetissue.navigation.BottomNavigation
import com.katajona.bottomsheetissue.navigation.destinations.HomeScreens
import com.katajona.bottomsheetissue.navigation.NavigationType
import com.katajona.bottomsheetissue.navigation.Router
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                MainContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun MainContent() {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberNavController(bottomSheetNavigator)
    val startDestination by remember { mutableStateOf(HomeScreens.Home.get().route) }
    ListenToNavigation(navController)

    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) },
    ) { padding ->
        ModalBottomSheetLayout(bottomSheetNavigator, sheetBackgroundColor = Color.Transparent) {
            AppNavHost(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                navController = navController,
                startDestination = startDestination
            )
        }
    }
}

@Composable
fun ListenToNavigation(
    navController: NavHostController,
    router: Router = koinInject(),
) {
    LaunchedEffect(Unit) {
        router.sharedFlow.collect {
            when (it) {
                is NavigationType.NavigateTo -> navController.navigate(
                    it.target.route,
                    it.navOptions
                )
            }
        }
    }
}

