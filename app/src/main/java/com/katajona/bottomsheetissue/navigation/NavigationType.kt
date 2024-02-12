package com.katajona.bottomsheetissue.navigation

import androidx.navigation.NavOptions

sealed class NavigationType {
    data class NavigateTo(val target: NavigationDestination, val navOptions: NavOptions? = null) : NavigationType()
}
