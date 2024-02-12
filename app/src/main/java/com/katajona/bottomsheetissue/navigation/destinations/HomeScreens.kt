package com.katajona.bottomsheetissue.navigation.destinations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import com.katajona.bottomsheetissue.R
import com.katajona.bottomsheetissue.navigation.BottomNavItem
import com.katajona.bottomsheetissue.navigation.NavigationDestination
import com.katajona.bottomsheetissue.screens.ExtraDataScreen
import com.katajona.bottomsheetissue.screens.HomeScreen

object HomeScreens {
    data object Home :
        NavRoute, BottomNavItem(R.string.home, Icons.Default.Home) {
        override val screen = NavGraphView.ComposableGraphView(this) {
            HomeScreen()
        }
        fun get(): NavigationDestination = getRouteWithParams()

    }

    data object ExtraData : NavRoute {

        override val screen = NavGraphView.ComposableGraphView(this) {
            ExtraDataScreen()
        }

        fun get(): NavigationDestination = getRouteWithParams()

    }
}