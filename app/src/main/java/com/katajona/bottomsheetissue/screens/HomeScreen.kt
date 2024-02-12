package com.katajona.bottomsheetissue.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.katajona.bottomsheetissue.navigation.destinations.HomeScreens
import com.katajona.bottomsheetissue.navigation.NavigationType
import com.katajona.bottomsheetissue.navigation.Router
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(router: Router = koinInject()) {
    Column {
        Text(text = "Home")
        Button(onClick = {
            router.dispatch(NavigationType.NavigateTo(HomeScreens.ExtraData.get()))
        }) {
            Text(text = "open ExtraDataScreen")
        }

    }
}