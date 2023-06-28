package com.pd.sportsnetwork.ui.state

sealed interface MainActivityUiState {
    object ShowSplashScreen : MainActivityUiState
    object MoveToFeedScreen : MainActivityUiState
}