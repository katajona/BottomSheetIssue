package com.katajona.bottomsheetissue.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.katajona.bottomsheetissue.navigation.destinations.HomeScreens
import com.katajona.bottomsheetissue.navigation.destinations.NavRoute

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        registerScreens()
    }
}
@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(HomeScreens.Home, HomeScreens.Home)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val selected = items.find { it.getRouteUrlWithParams() == currentDestination?.route } ?: return
    RbBottomNavigation(
        items = items, selectedItem = selected, onItemSelectionChanged = { item ->
            navController.navigate((item as NavRoute).getRouteUrlWithParams()) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
            }
        }
    )
}
