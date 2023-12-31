package com.pd.sportsnetwork

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pd.sportsnetwork.ui.state.MainActivityUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val SPLASH_DELAY = 1200L

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {
    private var _uiState =
        MutableStateFlow<MainActivityUiState>(MainActivityUiState.ShowSplashScreen)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            showSplashScreen()
        }
    }

    private suspend fun showSplashScreen() {
        delay(SPLASH_DELAY)
        _uiState.value = MainActivityUiState.MoveToFeedScreen
    }
}
