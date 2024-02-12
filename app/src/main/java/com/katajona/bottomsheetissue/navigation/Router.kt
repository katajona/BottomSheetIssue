package com.katajona.bottomsheetissue.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

open class Router : CoroutineScope by CoroutineScope(Dispatchers.Main) {
    private val _eventChannel = Channel<NavigationType>(Channel.BUFFERED)
    val sharedFlow = _eventChannel.receiveAsFlow()

    open fun dispatch(navTarget: NavigationType) {
        launch {
            _eventChannel.send(navTarget)
        }
    }
}