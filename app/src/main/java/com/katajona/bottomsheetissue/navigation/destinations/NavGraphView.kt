package com.katajona.bottomsheetissue.navigation.destinations

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

sealed class NavGraphView {

    data class ComposableGraphView(
        val navRoute: NavRoute,
        val content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
    ) : NavGraphView() {
        override fun build(navGraphBuilder: NavGraphBuilder) {
            navGraphBuilder.composable(
                route = navRoute.getRouteUrlWithParams(),
                arguments = navRoute.arguments,
                deepLinks = navRoute.absoluteDeepLinks,
                content = content
            )
        }
    }
    abstract fun build(navGraphBuilder: NavGraphBuilder)
}