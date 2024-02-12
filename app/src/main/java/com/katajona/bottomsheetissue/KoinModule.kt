package com.katajona.bottomsheetissue

import com.katajona.bottomsheetissue.navigation.Router
import org.koin.dsl.module

val koinModule = module {
    single { Router() }
}
