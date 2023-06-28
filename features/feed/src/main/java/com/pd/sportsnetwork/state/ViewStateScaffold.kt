package com.pd.sportsnetwork.state

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pd.sportsnetwork.composables.elements.Feed

@Composable
fun ViewStateScaffold(
    viewState: FeedFlowUiState,
    modifier: Modifier,
    loading: @Composable BoxScope.() -> Unit = {},
    showFeed: @Composable BoxScope.(FeedFlowUiState.ShowFeed) -> Unit = {},
    failure: (FeedFlowUiState.Error) -> Unit = {},
    idle: @Composable BoxScope.() -> Unit = {},
) {
    Box(modifier = modifier) {
        when (viewState) {
            is FeedFlowUiState.Loading -> loading()
            is FeedFlowUiState.ShowFeed -> Feed(viewState)
            is FeedFlowUiState.Error -> failure(viewState)
            is FeedFlowUiState.Idle -> idle()
        }
    }
}