package com.rpn.iiucstudy.presentation.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {

    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    private val _state = MutableStateFlow<HomeScreenState>(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = HomeScreenState(),
    )

    init {
        onEvent(HomeScreenEvents.LoadHomeData)
    }

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.LoadHomeData -> {
                viewModelScope.launch {
                    getHeadLineData()
                }
            }
        }
    }

    private suspend fun getHeadLineData() {

    }

}