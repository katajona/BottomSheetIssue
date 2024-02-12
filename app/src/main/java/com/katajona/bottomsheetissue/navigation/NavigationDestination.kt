package com.katajona.bottomsheetissue.navigation

import androidx.navigation.NavGraphBuilder
import com.katajona.bottomsheetissue.navigation.destinations.NavRoute

data class NavigationDestination(val route: String)

fun NavGraphBuilder.registerScreens() {
    NavRoute::class.sealedSubclasses.forEach { it.objectInstance?.screen?.build(this) }
}